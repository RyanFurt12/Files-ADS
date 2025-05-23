import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        int[] vetor = { 5, 9, 7, 4, 6, 1, 2, 3, 10, -1 };
        
        System.out.println("Array inicial" + Arrays.toString(vetor));
        
        System.out.println("Sorting...");
        quickSort(vetor);

        System.out.println("Array final" + Arrays.toString(vetor));
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial) + " ms");
    }

    public static void quickSort(int[] v){
        if (v.length<=1) return;
        quickSort(v, 0, v.length-1);
    }

    public static void quickSort(int[] v, int pi, int pf) {
        if(pi >= pf) return;

        int p = pi, i = pi+1, f = pf;
        while (i < f) {
            if(v[f] > v[p]) f--;
            else if(v[i] < v[p]) i++;
            else changePos(v, i, f);
        }
        changePos(v, p, i);

        if (pi < i-1) quickSort(v, pi, i-1);
        if (pf > i+1) quickSort(v, i+1, pf);
    }

    public static void changePos(int[] v, int p1, int p2){
        int aux = v[p1];
        v[p1] = v[p2];
        v[p2] = aux;
    }
}