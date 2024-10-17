public class Main {
    public static void main(String[] args) {
        Utils.clearScreen();

        int linhas = 10;
        int colunas = linhas;

        Matriz m1 = new Matriz("rand 1", linhas, colunas, true, false);
        Matriz m2 = new Matriz("rand 2", linhas, colunas, true, false);

        SomaTotal.exec(m1);
        SomaTotal.exec(m2);

        Soma2Matrizes.exec(m1, m2);
    }
}

class Utils {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}