public class AVLTreeClass{
    public static void main(String[] args) {
        AVLTree bt = new AVLTree();

        int[] v = {50, 67, 12, 5, 2, 3, 7, 1};
        for (int n : v) bt.append(n);
        
        bt.print("preOrder");
        bt.print("Order");
        bt.print("posOrder");
    }
}

class AVLTree {
    private AVLTreeNode root = null;

    AVLTree(){}
    AVLTree(int value){
        this.append(value);
    }

    public void append(int value) {
        AVLTreeNode newNode = new AVLTreeNode(value);
        root = (root == null) ? newNode : root.append(newNode);
    }

    public void print(String type){
        System.out.print(type + ": [");
        this.root.print(type);
        System.out.print("]\n");
    }
}

class AVLTreeNode {
    int value;
    int height = 1;
    AVLTreeNode left = null;
    AVLTreeNode right = null;

    AVLTreeNode(int value){
        this.value = value;
    }

    AVLTreeNode append(AVLTreeNode newNode) {
        boolean goLeft = newNode.value < this.value;

        if (goLeft) left  = (left  == null) ? newNode : left.append(newNode); 
        else right = (right == null) ? newNode : right.append(newNode);

        updateHeight();
        return balance();
    }

    private void updateHeight() { height = 1 + Math.max(h(left), h(right)); }
    private int getBalance() { return h(left) - h(right); }
    private int getBalance(AVLTreeNode n) { return n == null ? 0 : n.getBalance();}
    
    private static int h(AVLTreeNode n) { return n == null ? 0 : n.height; }

    private AVLTreeNode balance() {
        int bal = getBalance();

        if (bal > 1 && getBalance(left) >= 0) return rotateRight();
        if (bal < -1 && getBalance(right) <= 0) return rotateLeft();
        if (bal > 1) { left = left.rotateLeft(); return rotateRight(); }
        if (bal < -1){ right = right.rotateRight(); return rotateLeft(); }

        return this;
    }
    
    private AVLTreeNode rotateRight() {
        AVLTreeNode x = left;
        AVLTreeNode T2 = x.right;

        x.right = this;
        left    = T2;

        updateHeight();
        x.updateHeight();
        return x;
    }
    private AVLTreeNode rotateLeft() {
        AVLTreeNode y = right;
        AVLTreeNode T2 = y.left;

        y.left = this;
        right  = T2;

        updateHeight();
        y.updateHeight();
        return y;
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