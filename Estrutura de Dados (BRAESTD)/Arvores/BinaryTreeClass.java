public class BinaryTreeClass{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(9);

        bt.append(50);
        bt.append(67);
        bt.append(12);
        bt.append(5);
        bt.append(2);
        bt.append(3);
        bt.append(7);

        bt.print("preOrder");
        bt.print("Order");
        bt.print("posOrder");
    }
}

class BinaryTree {
    private BinaryTreeNode root = null;

    BinaryTree(){}
    BinaryTree(int value){
        this.append(value);
    }

    public void append(int value){
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if(this.root == null){
            this.root = newNode;
            return;
        }
        this.root.append(newNode);
    }

    public void print(String type){
        System.out.print(type + ": [");
        this.root.print(type);
        System.out.print("]\n");
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left = null;
    BinaryTreeNode right = null;

    BinaryTreeNode(int value){
        this.value = value;
    }

    public void append(BinaryTreeNode newNode){
        if(newNode.value < this.value){
            if(this.left == null){
                this.left = newNode;
                return;
            }
            this.left.append(newNode);
        }
        else{
            if(this.right == null){
                this.right = newNode;
                return;
            }
            this.right.append(newNode);
        }
    }

    public void print(String type){
        if(type == "preOrder"){
            System.out.print(this.value + ", ");
            if(this.left != null) this.left.print(type);
            if(this.right != null) this.right.print(type);
        }
        if(type == "Order"){
            if(this.left != null) this.left.print(type);
            System.out.print(this.value + ", ");
            if(this.right != null) this.right.print(type);
        }
        if(type == "posOrder"){
            if(this.left != null) this.left.print(type);
            if(this.right != null) this.right.print(type);
            System.out.print(this.value + ", ");
        }
    }
}