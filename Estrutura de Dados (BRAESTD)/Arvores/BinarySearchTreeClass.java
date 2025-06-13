public class BinaryTreeClass{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        int[] v = {50, 67, 12, 5, 2, 3, 7, 1};
        for (int n : v) bt.append(n);
        
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
        boolean goLeft = newNode.value < this.value;
        BinaryTreeNode child = goLeft ? this.left : this.right; 

        if(child == null){
            if(goLeft) this.left = newNode;
            else this.right = newNode;    
            return;
        }
        child.append(newNode);
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