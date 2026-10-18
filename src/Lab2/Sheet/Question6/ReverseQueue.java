package Lab2.Sheet.Question6;

import Lab2.Sheet.Question1.Stack;
import Lab2.Sheet.Question3.Queue;

public class ReverseQueue<T> {
    public void reverseQueue(Queue<T> q){
        Stack<T> stk = new Stack<>();
        while (!q.isEmpty()){
            stk.push(q.deque());
        }
        while (!stk.isEmpty()){
            q.enque(stk.pop());
        }
    }
}
