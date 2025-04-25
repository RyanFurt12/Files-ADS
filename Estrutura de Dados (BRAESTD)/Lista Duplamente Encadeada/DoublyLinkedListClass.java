public class DoublyLinkedListClass{
    public static void main(String[] args) {
        DoublyLinkedList<Integer> lk = new DoublyLinkedList<Integer>(8);
        
        lk.append(15);
        lk.append(12);
        lk.append(12);
        lk.append(12);
        lk.pop();
        lk.shift();
        lk.push(1);
        lk.append(2);
        
        lk.print();
    }
}

class DoublyLinkedList<T> {
    private DoublyLinkedListNode<T> first = null;

    DoublyLinkedList(){}
    DoublyLinkedList(T value){
        this.append(value);
    }

    public void append(T value){
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value);
        if(this.first == null){
            this.first = newNode;
            return;
        }
        this.first.append(newNode);
    }

    public void push(T value){
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value, this.first);
        this.first.last = newNode;
        this.first = newNode;
    }

    public void pop(){
        if (this.first == null) return;
        if (this.first.next == null){
            this.first = null;
        }

        this.first.pop();
    }

    public void shift(){
        this.first = this.first.next;
        this.first.last = null;
    }

    public void print(){
        System.out.print("[");
        this.first.print();
        System.out.print("]\n");
    }
}

class DoublyLinkedListNode<T> {
    T value;
    DoublyLinkedListNode<T> next = null;
    DoublyLinkedListNode<T> last = null;

    DoublyLinkedListNode(T value){
        this.value = value;
    }
    DoublyLinkedListNode(T value, DoublyLinkedListNode<T> next){
        this.value = value;
        this.next = next;
    }

    public void append(DoublyLinkedListNode<T> newNode){
        if(this.next == null){
            this.next = newNode;
            newNode.last = this;
            return;
        }
        this.next.append(newNode);
    }

    public void pop(){
        if(this.next.next == null){
            this.next = null;
            return;
        }

        this.next.pop();
    }

    public void print(){
        System.out.print(this.value + (this.next != null? ", " : ""));
        if(this.next != null) this.next.print();
    }
}