import java.util.EmptyStackException;
import java.util.Scanner;

public class ExercicioPilha{
    public static void main(String[] args) {
        Pilha p = new Pilha();
        Scanner s = new Scanner(System.in);
        Integer op = -1;

        System.out.println("Digite (3|2|1|0|-1) e pressione enter, até finalizar as ações:");
        while (true) {
            op = s.nextInt();
            if(op == -1) break;
            if(op == 0) p.remover();
            if(op > 0 && op < 4) p.inserir(op);
        }
        s.close();
        
        System.out.println("\nResposta:");
        p.imprimir();
    }
}

class Pilha{
    Item top = null;

    public void inserir(Integer value){
        this.top = new Item(value, top);
    }

    public void remover(){
        if (this.top == null) throw new EmptyStackException();
        this.top = this.top.next;
    }
    
    public void imprimir(){
        if (this.top == null) System.out.println(-1);
        else this.top.imprimir();
    }
}

class Item{
    Item next;
    Integer value;

    Item(Integer value, Item next){
        this.value = value;
        this.next = next;
    }

    public void imprimir(){
        if(next != null) this.next.imprimir();
        System.out.println(value);
    }
}