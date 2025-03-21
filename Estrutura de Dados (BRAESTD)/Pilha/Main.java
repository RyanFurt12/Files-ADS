
public class Main
{
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha<Integer>();
        
        System.out.println("Empilhando 5");
        p.empilhar(5);
        
        System.out.println("Empilhando 15");
        p.empilhar(15);

        System.out.println("Desempilhando o: " + p.desempilhar());

        System.out.println("Empilhando 7");
        p.empilhar(7);
        
        System.out.println("Empilhando 8");
        p.empilhar(8);

        System.out.println("Empilhando 6");
        p.empilhar(6);
        
        p.printarPilha();

        System.out.println("topo: " + p.retornarTopo());

        System.out.println("Desempilhando o: " + p.desempilhar());

        System.out.println("topo: " + p.retornarTopo());

        System.out.println("Desempilhando o: " + p.desempilhar());

        System.out.println("Desempilhando o: " + p.desempilhar());
        
    }
}
