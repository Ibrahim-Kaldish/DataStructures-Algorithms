package Lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack <T> implements Iterable<T>{
    static class Node<T> {
        T value;
        Node<T> next;

        Node(T val){
            this.value = val;
        }
    }

    Node<T> top ;

    public boolean isEmpty(){
        return top == null ;
    }

    public void push(T item){
        Node<T> newNode = new Node<>(item);
        newNode.next = top ;
        top = newNode;
    }

    public T pop(){
        if (isEmpty()){
            System.out.println("Stack is empty !!");
            return null;
        }
        T val = top.value;
        top = top.next;
        return val;
    }

    public T getTop(){
        if (isEmpty()){
            System.out.println("Stack is empty !!");
            return null;
        }
        return top.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node <T> node = top ;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                else {
                    T val = node.value;
                    node = node.next;   // walk downward, top -> bottom
                    return val;
                }
            }
        };
    }
}
