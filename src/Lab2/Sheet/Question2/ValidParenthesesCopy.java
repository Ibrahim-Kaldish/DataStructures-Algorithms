package Lab2.Sheet.Question2;

import Lab2.Sheet.Question1.Stack;

public class ValidParenthesesCopy {
    public boolean checkValidParentheses(String s){
        Stack<Character> stk = new Stack<>();

        //{[()]}
        //{
        for (char c: s.toCharArray()){
            if (stk.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') return false;
                else stk.push(c);
            }
            else{
                char top = stk.peek();
                if ( (top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']'))
                    stk.pop();
                else stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}

