package Lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray <T> implements Iterable<T> {
    Object[] arr ;
    int top;
    int sz ;


    public StackArray(int n){
        arr = new Object[n];
        top = -1 ;
        this.sz = n ;
    }

    public boolean isEmpty(){
        return top == -1 ;
    }

    public T getTop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return (T) arr[top];
    }

    public void push (T item){
        if (top + 1 >= sz){
            System.out.println("Stack is full");
        }
        arr[++top] = item;
    }

    public T pop (){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return (T) arr[top--];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = top;      // start at the top of the stack

            @Override
            public boolean hasNext() {
                return cursor >= 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) arr[cursor--];  // walk downward, top -> bottom
            }
        };
    }
}
