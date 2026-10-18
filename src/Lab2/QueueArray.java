package Lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueArray <T> implements Iterable<T>{
    Object[] arr;
    int front = -1 ;
    int rear = -1;
    int cnt = 0;
    final int MAX_SIZE;


    public QueueArray(int n){
        MAX_SIZE = n ;
        arr = new Object[MAX_SIZE];
    }

    public boolean isEmpty(){
        return cnt == 0;
    }

    public void enqueue(T item){
        if (cnt < MAX_SIZE) {
            rear = (rear+1) % MAX_SIZE;
            arr[rear] = item;
            cnt++;
            if (cnt == 1) front = rear;
        }
        else
            System.out.println("Queue is full, you can't add more items !!");
    }

    public T dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't remove more items !!");
            return null;
        }
        else
        {
            T val = (T) arr[front];
            front = (front+1) % MAX_SIZE;
            cnt--;
            return val;
        }
    }

    public T getFront(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't get any item !!");
            return null;
        }
        return (T) arr[front];
    }
    public T getRear(){
        if (isEmpty()) {
            System.out.println("Queue is empty, you can't get any item !!");
            return null;
        }
        return (T) arr[rear];
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = front;
            private int elements = cnt;

            @Override
            public boolean hasNext() {
                return elements != 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                else{
                    T val = (T) arr[cursor];
                    cursor = (cursor+1) % MAX_SIZE;
                    elements--;
                    return val;
                }
            }
        };
    }
}
