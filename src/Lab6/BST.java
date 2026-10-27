package Lab6;

public class BST <T extends Comparable<T>>{
    public static class Node <T>{
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val){
            this.val = val;
        }
    }

    public Node<T> root;
    public BST(){}

    public boolean isEmpty(){
        return root == null;
    }

    private void insertIntoBST(T val, Node<T> root){
        if (root != null){
            if ( val.compareTo(root.val) <= 0) {
                if (root.left == null) root.left = new Node<>(val);
                else insertIntoBST (val, root.left);
            }
            else {
                if (root.right == null) root.right = new Node<>(val);
                else insertIntoBST (val, root.right);
            }
        }
    }
    public void insert(T val){
        if (isEmpty()) {
            root = new Node<>(val);
            return ;
        }
        insertIntoBST(val, root);
    }

    public boolean searchInBST(T val, Node<T> root){
        if (root != null){
            if (val.compareTo(root.val) < 0){
                return searchInBST(val, root.left);
            }
            else if (val.compareTo(root.val) > 0){
                return searchInBST(val, root.right);
            }
            else
                return true;
        }
        return false;
    }
    public boolean search(T val){
        return searchInBST(val, root);
    }

    public T delete(T val){
        if (isEmpty()){
            System.out.println("BST is already empty !!");
            return null;
        }
        if (!search(val)){
            System.out.println("Node doesn't exist");
            return null;
        }
        root = deleteFromBST(val, root);
        return val;
    }
    private Node<T> deleteFromBST(T val, Node<T> root){
        if (root != null){
            if (val.compareTo(root.val) < 0){
                root.left = deleteFromBST(val, root.left);
            }
            else if (val.compareTo(root.val) > 0){
                root.right = deleteFromBST(val, root.right);
            }
            else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                Node<T> succ = root.right;
                while (succ.left != null) succ = succ.left;
                root.val = succ.val;
                root.right = deleteFromBST(succ.val, root.right);
            }
            return root;
        }
        return null;
    }

    public int countNodes(Node<T> root){
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int countNodes(){
        return countNodes(root);
    }

    public int height(Node<T> root){
        if (root == null ) return 0;
        return 1 + Math.max (height(root.left), height(root.left));
    }
    public int height(){
        return height(root);
    }

    public T max(Node<T> root){
        if (isEmpty()) return null;
        while (root.right != null) root = root.right;
        return root.val;
    }
    public T max(){
        return max(root);
    }

    public T min(Node<T> root){
        if (isEmpty()) return null;
        while (root.left != null) root = root.left;
        return root.val;
    }
    public T min(){
        return min(root);
    }

    private void preorder(Node<T> root){
        if (root != null){
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void preorder(){
        preorder(root);
    }

    private void inorder(Node<T> root){
        if (root != null){
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    public void inorder(){
        inorder(root);
    }

    private void postorder(Node<T> root){
        if (root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }
    public void postorder(){
        postorder(root);
    }
}