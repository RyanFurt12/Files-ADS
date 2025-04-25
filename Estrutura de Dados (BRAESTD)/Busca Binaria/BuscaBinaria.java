public class BuscaBinaria {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Res: " + buscaBinaria(8, a, 0, a.length-1)); 
    }

    static int buscaBinaria(int buscar, int[] itens, int ini, int fim){
        int meio = (ini + fim) / 2;
        if(ini>=fim) return -1;
        if(itens[meio] == buscar) return meio;
        if(itens[meio] < buscar) return buscaBinaria(buscar, itens, meio+1, fim);
        if(itens[meio] > buscar) return buscaBinaria(buscar, itens, ini, meio-1);

        return -1;
    }
}
