import java.util.Arrays;

public class HashSimple {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        insertHash(vetor, 19);

        System.out.println("Array:" + Arrays.toString(vetor));
    }

    public static void insertHash(int[] v, int va){
        int pos = va % v.length;
        v[pos] = va;
    } 
}