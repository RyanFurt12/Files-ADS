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
        for (int i = vetor.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    changePos(vetor, j, j+1);
                }
            }
        }
    }
    
    public static void changePos(int[] v, int p1, int p2){
        int aux = v[p1];
        v[p1] = v[p2];
        v[p2] = aux;
    }

}