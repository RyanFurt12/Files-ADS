import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        
        int[] vetor = { 5, 9, 7, 4, 6, 1, 2, 3, 10, -1 };
        
        System.out.println("Array inicial" + Arrays.toString(vetor));
        
        System.out.println("Sorting...");
        bubbleSort(vetor);

        System.out.println("Array final" + Arrays.toString(vetor));
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial) + " ms");
    }

    public static void bubbleSort(int[] vetor) {
        int l = vetor.length;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j < l - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }

            }
        }
    }

}