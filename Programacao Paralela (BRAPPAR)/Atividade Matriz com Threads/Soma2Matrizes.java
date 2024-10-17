public class Soma2Matrizes extends Thread{
    private int[] l1;
    private int[] l2;
    private int[] result;

    public Soma2Matrizes(int[] l1, int[] l2, int[] result) {
        this.l1 = l1;
        this.l2 = l2;
        this.result = result;
    }

    @Override
    public void run() {
        for (int i = 0; i < l1.length; i++) {
            result[i] = l1[i] + l2[i];
            // try { Thread.sleep(100); } catch (Exception e) {}
        }
    }

    public static void exec(Matriz m1, Matriz m2){
        int linhas = m1.linhas;
        int colunas = m1.colunas;

        Matriz result = new Matriz("Resultado", linhas, colunas, false, false);

        Thread[] threads = new Thread[linhas];

        for (int i = 0; i < linhas; i++) {
            threads[i] = new Soma2Matrizes(m1.matriz[i], m2.matriz[i], result.matriz[i]);
            threads[i].start();
        }

        for (int i = 0; i < linhas; i++) {
            try { threads[i].join(); } catch (Exception e) {}
        }

        System.out.println("\nResultado da soma das matrizes:");
        result.print();
    }
}