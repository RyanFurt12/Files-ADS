import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        
        int[] vetor = { 5, 9, 7, 4, 6, 1, 2, 3, 10, -1 };
        
        System.out.println("Array inicial" + Arrays.toString(vetor));
        
        System.out.println("Sorting...");
        selectionSort(vetor);

        System.out.println("Array final" + Arrays.toString(vetor));
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial) + " ms");
    }

    public static void selectionSort(int[] vetor) {
        int l = vetor.length;
        for (int i = 0; i < l; i++) {
            int min = i;
            for (int j = i; j < l; j++) {
                if (vetor[min] > vetor[j]) min = j;
            }
            changePos(vetor, i, min);
        }
    }

    public static void changePos(int[] v, int p1, int p2){
        int aux = v[p1];
        v[p1] = v[p2];
        v[p2] = aux;
    }

}