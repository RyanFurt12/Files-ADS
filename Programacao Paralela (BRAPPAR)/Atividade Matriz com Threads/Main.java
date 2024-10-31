
public class Main {
    public static void main(String[] args) {
        Utils.clearScreen();

        // TesteCallable aa = new TesteCallable();
        // try { System.out.println(aa.call()); } catch (Exception e) {}

        
    // SOMA OS ITENS DE UMA MATRIZ
        int linhas = 20000;
        int colunas = linhas;

        Matriz m1 = new Matriz("rand 1", linhas, colunas, true, false);
        
        SomaTotal.exec(m1, true);

        
    // SOMA DE 2 MATRIZES
        // int linhas = 1000;
        // int colunas = linhas;

        // Matriz m1 = new Matriz("rand 1", linhas, colunas, true, false);
        // Matriz m2 = new Matriz("rand 2", linhas, colunas, true, false);
        // Soma2Matrizes.exec(m1, m2);
    }
}

class Utils {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}