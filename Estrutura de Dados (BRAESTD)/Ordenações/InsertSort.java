import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        
        int[] vetor = { 5, 9, 7, 4, 6, 1, 2, 3, 10, -1 };
        
        System.out.println("Array inicial" + Arrays.toString(vetor));
        
        System.out.println("Sorting...");
        insertSort(vetor);

        System.out.println("Array final" + Arrays.toString(vetor));
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial) + " ms");
    }

    public static void insertSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (v[j] > v[j-1]) break;
                changePos(v, j, j-1);
            }
        }
    }
    
    public static void changePos(int[] v, int p1, int p2){
        int aux = v[p1];
        v[p1] = v[p2];
        v[p2] = aux;
    }
}