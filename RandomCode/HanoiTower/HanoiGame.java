import java.util.Arrays;
import java.util.Scanner;

public class HanoiGame {
    public static void main(String[] args) {
        Hanoi h = new Hanoi(5);
        h.startGame();
    }
}

class Hanoi {
    private int[][] hanoiTower;
    private int[] topIndexes;
    private int numberOfBlocks;
    private int moveCount;

    Hanoi(int length) {
        if (length < 1)
            length = 5;

        this.numberOfBlocks = length;
        this.moveCount = 0;

        this.hanoiTower = new int[3][length];
        for (int i = 0; i < length; i++) {
            this.hanoiTower[0][i] = length - i;
        }

        this.topIndexes = new int[3];
        this.topIndexes[0] = length - 1;
        this.topIndexes[1] = -1;
        this.topIndexes[2] = -1;
    }

    public Hanoi() {
        this(5);
    }

    public void startGame() {
        while (true) {
            this.printTower();
            int[] movePos = this.askForMove();

            boolean wasMoved = this.tryMove(movePos[0], movePos[1]);
            if (!wasMoved)
                continue;

            if (this.isWin()) {
                System.out.println("\n\nParabéns, você ganhou");
                this.printTower();
                break;
            }
        }
    }

    public int[] askForMove() {
        Scanner sc = new Scanner(System.in);
        int pos1 = 0, pos2 = 0;

        while (true) {
            try {
                System.out.print("Digite a primeira posição (1 a 3): ");
                pos1 = sc.nextInt();
                if (pos1 < 1 || pos1 > 3) {
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }

                System.out.print("Digite a segunda posição (1 a 3): ");
                pos2 = sc.nextInt();
                if (pos2 < 1 || pos2 > 3) {
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine();
            }
        }

        return new int[] { pos1, pos2 };
    }

    public boolean tryMove(int t1, int t2) {
        this.moveCount++;
        --t1;
        --t2;

        if (topIndexes[t1] == -1) {
            System.out.println("Torre selecionada vazia");
            return false;
        }

        int t1P = this.hanoiTower[t1][topIndexes[t1]];
        int t2P = (this.topIndexes[t2] == -1) ? 1000 : this.hanoiTower[t2][this.topIndexes[t2]];

        if (t1P > t2P) {
            System.out.println("Movimento invalido");
            return false;
        }

        this.hanoiTower[t1][this.topIndexes[t1]--] = 0;
        this.hanoiTower[t2][++this.topIndexes[t2]] = t1P;

        return true;
    }

    public boolean isWin() {
        return topIndexes[2] == this.numberOfBlocks - 1;
    }

    public void printTower() {
        String space = "  ";
        System.out.println("\nMove count: " + this.moveCount);
        System.out.println();

        for (int l = this.numberOfBlocks - 1; l >= 0; l--) {
            for (int t = 0; t < 3; t++) {
                int disk = hanoiTower[t][l];

                String diskStr = disk == 0 ? "|" : "=".repeat(disk * 2 - 1);
                String line = center(diskStr, this.numberOfBlocks * 2 + 1);

                System.out.print(line + space);
            }
            System.out.println();
        }
        for (int i = 1; i <= 3; i++) {
            System.out.print(center(" " + i + " ", this.numberOfBlocks * 2 + 1) + space);
        }
        System.out.println("\n");
    }

    private String center(String text, int width) {
        int padSize = (width - text.length()) / 2;
        String padding = " ".repeat(Math.max(0, padSize));
        return padding + text + padding;
    }
}