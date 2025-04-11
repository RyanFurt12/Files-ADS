public class LinkedListClass{
    public static void main(String[] args) {
        LinkedList<Integer> lk = new LinkedList<Integer>(8);
        
        lk.append(15);
        lk.append(12);
        lk.push(1);
        lk.append(2);
        
        lk.print();
        
        LinkedList<Integer> ol = new LinkedList<Integer>(8);
        ol.orderPush(5);
        ol.orderPush(15);
        ol.orderPush(2);
        ol.orderPush(14);

        ol.print();
    }
}

class LinkedList<T> {
    private LinkedListNode<T> first = null;

    LinkedList(){}
    LinkedList(T value){
        this.append(value);
    }

    public void append(T value){
        LinkedListNode<T> newNode = new LinkedListNode<T>(value);
        if(this.first == null){
            this.first = newNode;
            return;
        }
        this.first.append(newNode);
    }

    public void push(T value){
        this.first = new LinkedListNode<T>(value, this.first);
    }

    @SuppressWarnings("unchecked")
    public void orderPush(T value){
        if(this.first == null || ((Comparable<T>) this.first.value).compareTo(value) > 0){
            this.push(value);
            return;
        }
        this.first.orderPush(value);
    }

    public void print(){
        System.out.print("[");
        this.first.print();
        System.out.print("]\n");
    }
}

class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next = null;

    LinkedListNode(T value){
        this.value = value;
    }
    LinkedListNode(T value, LinkedListNode<T> next){
        this.value = value;
        this.next = next;
    }

    public void append(LinkedListNode<T> newNode){
        if(this.next == null){
            this.next = newNode;
            return;
        }
        this.next.append(newNode);
    }

    @SuppressWarnings("unchecked")
    public void orderPush(T value){
        if(this.next == null || ((Comparable<T>) this.next.value).compareTo(value) > 0){
            this.next = new LinkedListNode<T>(value, next);
            return;
        }
        this.next.orderPush(value);
    }

    public void print(){
        System.out.print(this.value + (this.next != null? ", " : ""));
        if(this.next != null) this.next.print();
    }
}