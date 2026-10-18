package Lab2.Sheet.Question1;


public class StackCopy <T> {
    static class Node<T>{
        T value ;
        Node<T> next ;

        Node(T val){
            this.value = val ;
        }
    }

    Node<T> top = null ;
    int sz = 0;

    public boolean isEmpty(){
        return top == null;
    }

    public T peek(){
        if (isEmpty()){
            System.out.println("Stack is Empty !!");
            return null;
        }
        return top.value;
    }

    public void push(T item){
        Node<T> node = new Node<>(item);
        node.next = top ;
        top = node;
        sz++;
    }

    public T pop(){
        if (this.isEmpty()){
            System.out.println("Stack is Empty !!");
            return null;
        }
        else{
            T v = top.value;
            top = top.next;
            sz--;
            return v;
        }
    }

    public int size(){
        return sz ;
    }
//                    n
//    3 -> 2 -> 1 -> null
    public void display(){
        Node<T> node = top;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
            // 1 2
        }
    }
}
