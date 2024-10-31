import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SomaTotal implements Runnable {
    private int[][] matriz;
    private int start;
    private int end;
    private int[] result;

    public SomaTotal(int[][] matriz, int start, int end, int[] result) {
        this.matriz = matriz;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        int localSum = 0;
        for (int i = start; i < end; i++) {
            for (int num : matriz[i]) {
                localSum += num;
            }
        }
        synchronized (result) {
            result[0] += localSum;
        }
    }

    public static void exec(Matriz m) {
        long startTime = System.currentTimeMillis();

        int[] result = new int[1]; 
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        int numRows = m.linhas;
        int maxRowsPerThread = (int) Math.ceil((double) numRows / 4);

        for (int i = 0; i < numRows; i += maxRowsPerThread) {
            int end = Math.min(i + maxRowsPerThread, numRows);
            executor.submit(new SomaTotal(m.matriz, i, end, result));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("\nSoma da " + m.nome + " com threads: " + result[0]);
        long endTime = System.currentTimeMillis();
        System.out.println("Levou "+ (endTime - startTime) +" ms para executar");
    }

    public static void exec(Matriz m, boolean compararComSequencial) {
        SomaTotal.exec(m);
        
        if(compararComSequencial){
            long startTime = System.currentTimeMillis();
            int sum = 0;
            for (int[] l : m.matriz) {
                for (int c : l) {
                    sum += c;
                }
            }
            System.out.println("soma da " + m.nome +" sem thread: " + sum);
            long endTime = System.currentTimeMillis();
            System.out.println("Levou "+ (endTime - startTime) +" ms para executar");
        }
    }
}
