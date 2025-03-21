// - Agatha Rizzo Cezar - BP3048705
// - Laura Naomi Ibusuki Hirano - BP3034348
// - Ryan Furtado de Almeida - BP3044165

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mpi.h>

#define INGREDIENT_MAX 50

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
    int localCount = 0;

    char typedIngredient[INGREDIENT_MAX];
    if (rank == 0) {
        printf("Digite o nome do ingrediente que deseja contar: ");
        fgets(typedIngredient, INGREDIENT_MAX, stdin);
        typedIngredient[strcspn(typedIngredient, "\n")] = 0;
    }
    MPI_Bcast(typedIngredient, INGREDIENT_MAX, MPI_CHAR, 0, MPI_COMM_WORLD);

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
                        if (strcmp(typedIngredient, ingredient) == 0) {
                            localCount++;
                        }
                    }
                    ingredientStart = ingredientEnd;
                }
            }
        }
        line = strtok(NULL, "\n");
    }

    free(buffer);
    MPI_File_close(&file);

    int totalCount;
    MPI_Reduce(&localCount, &totalCount, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    double elapsedTime = MPI_Wtime() - startTime;
    if (rank == 0) {
        printf("Total de aparições de '%s': %d\n", typedIngredient, totalCount);
        printf("Tempo de execução: %.4f s\n", elapsedTime);
    }

    MPI_Finalize();
    return 0;
}
