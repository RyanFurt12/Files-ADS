import java.util.EmptyStackException;
import java.util.Scanner;

public class ExercicioFila{
    public static void main(String[] args) {
        Balsa b = new Balsa();
        Scanner s = new Scanner(System.in);
        Integer code = -1;

        System.out.println("Digite os códigos dos carros (-1 = enviar balsa):");
        while (true) {
            code = s.nextInt();
            if(code == -1) break;
            else b.entrarCarro(code);
        }
        s.close();
        
        System.out.println("\nLibera saida:");
        b.liberarCarros();
    }
}

class Balsa{
    Integer maxLength = 6;
    Fila f1 = new Fila("Fila 01");
    Fila f2 = new Fila("Fila 02");

    public void entrarCarro(Integer code){
        if( f1.length < this.maxLength ) f1.inserir(code);
        else if( f2.length < this.maxLength ) f2.inserir(code);
        else System.out.println("Balsa está cheia");
    }

    public void liberarCarros(){
        System.out.println("f1 lenght:" + f1.length + " | f2 lenght:"+f2.length);
        while (f1.length != 0 || f2.length != 0) {
            if(f1.length > 0) f1.remover();
            if(f2.length > 0) f2.remover();
        }
        System.out.println("Balsa Livre");
    }
}

class Fila{
    FilaItem first = null;
    Integer length = 0;
    String name;

    Fila(String name){
        this.name = name;
    }

    public void inserir(Integer value){
        if(this.first == null){
            this.first = new FilaItem(value);
            this.length++;
        }
        else{
            this.first.inserir(value);
            this.length++;
        }
    }
    
    public void remover(){
        if(this.first == null) throw new EmptyStackException();
        System.out.println(this.name + ": Carro " + first.value + " removido!");
        this.first = this.first.next;
        this.length--;
    }
}

class FilaItem{
    FilaItem next = null;
    Integer value;

    FilaItem(Integer value){
        this.value = value;
    }

    public void inserir(Integer value){
        if(this.next == null) this.next = new FilaItem(value);
        else this.next.inserir(value);
    }
}