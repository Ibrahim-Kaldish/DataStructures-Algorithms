package Lab2.Sheet.Question3;

import Lab2.Sheet.Question1.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue <T> implements Iterable<T>{

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public void enque(T val){
        stack1.push(val);
    }

    public T deque(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        T val = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int size(){
        return stack1.size();
    }

    public boolean isEmpty(){
        return size() ==  0;
    }

    public T front(){
        if (isEmpty()){
            System.out.println("Queue is Empty !!");
            return null;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        T val = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public T tail(){
        return stack1.peek();
    }

    @Override
    public Iterator<T> iterator(){
        List<T> list = new ArrayList<>();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            T val = stack2.pop();
            list.add(val);
            stack1.push(val);
        }
        return list.iterator();
    }
}
