// - Agatha Rizzo Cezar - BP3048705
// - Laura Naomi Ibusuki Hirano - BP3034348
// - Ryan Furtado de Almeida - BP3044165

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mpi.h>

#define INGREDIENT_MAX 50
#define MAX_INGREDIENTS 1000
#define TOP_N_INGREDIENTS 5

typedef struct {
    char ingredient[INGREDIENT_MAX];
    int count;
} IngredientCount;

void updateIngredientCount(IngredientCount *ingredientsCounts, int *size, const char *ingredient, const int count) {
    for (int i = 0; i < *size; i++) {
        if (strcmp(ingredientsCounts[i].ingredient, ingredient) == 0) {
            ingredientsCounts[i].count += count;
            return;
        }
    }
    if (*size < MAX_INGREDIENTS) {
        strncpy(ingredientsCounts[*size].ingredient, ingredient, INGREDIENT_MAX);
        ingredientsCounts[*size].count = count;
        (*size)++;
    }
}

int compareCounts(const void *a, const void *b) {
    IngredientCount *ia = (IngredientCount *)a;
    IngredientCount *ib = (IngredientCount *)b;
    return ib->count - ia->count;
}

int main(int argc, char **argv) {
    MPI_Init(&argc, &argv);

    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if(size <= 1){
        printf("O programa necessita de ao menos 2 processos, tente novamente\n");
        return 0;
    }

    const char *filename = "full_dataset.csv";
    MPI_File file;
    MPI_Offset fileSize, localStart, localEnd;
    char *buffer;

    double startTime = MPI_Wtime();

    MPI_File_open(MPI_COMM_WORLD, filename, MPI_MODE_RDONLY, MPI_INFO_NULL, &file);
    MPI_File_get_size(file, &fileSize);
    fileSize--;

    MPI_Offset chunkSize = fileSize / size;
    localStart = rank * chunkSize;
    localEnd = (rank == size - 1) ? fileSize : localStart + chunkSize;

    if (rank != 0) {
        char temp;
        MPI_File_read_at(file, localStart, &temp, 1, MPI_CHAR, MPI_STATUS_IGNORE);
        while (temp != '\n' && localStart < localEnd) {
            localStart++;
            MPI_File_read_at(file, localStart, &temp, 1, MPI_CHAR, MPI_STATUS_IGNORE);
        }
        localStart++;
    }

    if (rank != size - 1) {
        char temp;
        MPI_File_read_at(file, localEnd, &temp, 1, MPI_CHAR, MPI_STATUS_IGNORE);
        while (temp != '\n' && localEnd < fileSize) {
            localEnd++;
            MPI_File_read_at(file, localEnd, &temp, 1, MPI_CHAR, MPI_STATUS_IGNORE);
        }
    }

    MPI_Offset localSize = localEnd - localStart;
    buffer = (char *)malloc(localSize + 1);
    MPI_File_read_at_all(file, localStart, buffer, localSize, MPI_CHAR, MPI_STATUS_IGNORE);
    buffer[localSize] = '\0';

    IngredientCount localCounts[MAX_INGREDIENTS] = {0};
    int localCountSize = 0;

    char *line = strtok(buffer, "\n");
    while (line != NULL) {
        char *start = strrchr(line, '[');
        if (start) {
            start++;
            char *end = strrchr(start, ']');
            if (end) {
                *end = '\0';

                char *ingredientStart = start;
                while (*ingredientStart) {
                    while (*ingredientStart == ' ' || *ingredientStart == ',' || *ingredientStart == '"') {
                        ingredientStart++;
                    }
                    if (*ingredientStart == '\0') break;

                    char *ingredientEnd = ingredientStart;
                    while (*ingredientEnd != ',' && *ingredientEnd != '\0' && *ingredientEnd != '"') {
                        ingredientEnd++;
                    }

                    size_t len = ingredientEnd - ingredientStart;
                    char ingredient[len + 1];
                    strncpy(ingredient, ingredientStart, len);
                    ingredient[len] = '\0';

                    if (strlen(ingredient) > 1) {
                        updateIngredientCount(localCounts, &localCountSize, ingredient, 1);
                    }
                    ingredientStart = ingredientEnd;
                }
            }
        }
        line = strtok(NULL, "\n");
    }

    free(buffer);
    MPI_File_close(&file);

    IngredientCount *globalCounts = (IngredientCount *)malloc(MAX_INGREDIENTS * size * sizeof(IngredientCount));
    memset(globalCounts, 0, MAX_INGREDIENTS * size * sizeof(IngredientCount));

    MPI_Gather(localCounts, MAX_INGREDIENTS * sizeof(IngredientCount), MPI_BYTE,
               globalCounts, MAX_INGREDIENTS * sizeof(IngredientCount), MPI_BYTE,
               0, MPI_COMM_WORLD);

    if (rank == 0) {
        IngredientCount consolidatedCounts[MAX_INGREDIENTS] = {0};
        int consolidatedSize = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < MAX_INGREDIENTS; j++) {
                if (globalCounts[i * MAX_INGREDIENTS + j].count > 0) {
                    updateIngredientCount(consolidatedCounts, &consolidatedSize,
                                            globalCounts[i * MAX_INGREDIENTS + j].ingredient,
                                            globalCounts[i * MAX_INGREDIENTS + j].count);


                }
            }
        }

        qsort(consolidatedCounts, consolidatedSize, sizeof(IngredientCount), compareCounts);

        printf("Top %d ingredientes mais usados:\n", TOP_N_INGREDIENTS);
        for (int i = 0; i < TOP_N_INGREDIENTS && consolidatedCounts[i].count > 0; i++) {
            printf("- %s: %d\n", consolidatedCounts[i].ingredient, consolidatedCounts[i].count);
        }

        double elapsedTime = MPI_Wtime() - startTime;
        printf("Tempo de execução: %.4f s\n", elapsedTime);
    }

    free(globalCounts);
    MPI_Finalize();
    return 0;
}
