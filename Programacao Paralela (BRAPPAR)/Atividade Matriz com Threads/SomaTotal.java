public class SomaTotal extends Thread{
    private int[] l1;
    private int[] result;

    public SomaTotal(int[] l1, int[] result) {
        this.l1 = l1;
        this.result = result;
    }

    @Override
    public void run() {
        for (int i = 0; i < l1.length; i++) {
            result[0] += l1[i];
        }
    }

    public static void exec(Matriz m){
        int[] result = {0};
        int linhas = m.matriz.length;
        Thread[] threads = new Thread[linhas];

        for (int i = 0; i < linhas; i++) {
            threads[i] = new SomaTotal(m.matriz[i], result);
            threads[i].start();
        }

        for (int i = 0; i < linhas; i++) {
            try { threads[i].join(); } catch (Exception e) {}
        }

        System.out.println("\nResultado da soma da matriz "+ m.nome + ": " + result[0]);
    }
}