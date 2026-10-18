package Lab2.Sheet.Question1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack <T> implements Iterable<T>{
    Node<T> top ;
    int sz = 0;

    class Node<T> {
        T value;
        Node<T> next = null;

        Node(T val){
           this.value = val ;
        }
    }

    public void push(T val){
        Node<T> node = new Node<>(val);
        node.next = top;
        top = node;
        sz++;
    }

    public T pop(){
        if (isEmpty()) {
            System.out.println("Empty Stack !!");
            return null;
        }
        T val = top.value ;
        top = top.next;
        sz--;
        return val;
    }

    public T peek(){
        if (isEmpty()) {
            System.out.println("Empty Stack !!");
            return null;
        }
        return top.value;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return sz ;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> peek = top;

            @Override
            public boolean hasNext() {
                return peek != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T val = peek.value;
                peek = peek.next;
                return val;
            }
        };
    }
}
