package Lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue <T> implements Iterable<T>{
    Node <T> front;
    Node <T> rear;

    static class Node<T>{
        T value;
        Node<T> next;
        Node (T val){
            this.value = val;
        }
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue(T item){
        Node<T> node = new Node<> (item);
        if (rear == null){
            rear = front = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public T dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't remove more items !!");
            return null;
        }
        else
        {
            T item = front.value;
            front = front.next;
            return item;
        }
    }

    public T getFront(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't get any item !!");
            return null;
        }
        return front.value;
    }

    public T getRear(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't get any item !!");
            return null;
        }
        return rear.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> first = front;

            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                else{
                    T val = first.value;
                    first = first.next;
                    return val;
                }
            }
        };
    }
}
