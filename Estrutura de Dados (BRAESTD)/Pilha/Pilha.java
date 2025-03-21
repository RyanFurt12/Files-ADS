import java.util.EmptyStackException;

public class Pilha<type>{
    private ItemPilha<type> topo;
    private int tamanho = 0;
    
    public void empilhar(type value){
        this.tamanho++;
        this.topo = new ItemPilha<type>(value, this.topo);
    }
    
    public type desempilhar(){
        if (verificarPilhaVazia()){
            throw new EmptyStackException();
        }

        type res = this.retornarTopo();
        this.tamanho--;
        this.topo = this.topo.anterior;
        return res;
    }
    
    public type retornarTopo(){
        return this.topo.value;
    }

    public boolean verificarPilhaVazia(){
        return this.tamanho == 0;
    }

    public void printarPilha(){
        System.out.print("Topo | ");
        int i = 0;
        ItemPilha<type> curr = this.topo;
        
        while (i < tamanho) {
            System.out.print(curr.value + ", ");
            i++;
            curr = curr.anterior;
        }
        System.out.println("| Fundo");
    }
}

class ItemPilha<type>{
    public type value;
    public ItemPilha<type> anterior;
    
    ItemPilha(type value, ItemPilha<type> anterior){
        this.value = value;
        this.anterior = anterior;
    }
}