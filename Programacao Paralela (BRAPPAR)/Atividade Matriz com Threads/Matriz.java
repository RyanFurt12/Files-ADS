import java.util.Random;

public class Matriz {
    String nome;
    int[][] matriz;
    int linhas;
    int colunas;
    Random random = new Random();

    public Matriz(String nome, int linhas, int colunas, boolean isRand, boolean isPrint) {
        this.nome = nome;
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];

        if(isRand){
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    matriz[i][j] = random.nextInt(4);
                }
            }
        }
        if (isPrint) {
            this.print();
        }
    }

    public void print() {
        System.out.println("Matriz "+this.nome+":");
        for (int i = 0; i < linhas; i++) {
            System.out.print("[  ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(this.matriz[i][j] + "  ");
            }
            System.out.println("]");
        }
    }
}
