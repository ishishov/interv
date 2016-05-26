package tests.com.cake;

import java.util.Stack;

/**
 * Created by ishishov on 4/12/16.
 */
public class CorrectParenthesis {

    public static void main(String[] args) {

        String s = "{}{()}{}}";

        Stack<Character> stack = new Stack();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            System.out.println("C: " + c);
            if (!stack.empty() && ((stack.peek() == '{' && c == '}') || (stack.peek() == '(' && c == ')'))) {
                stack.pop();
            } else {
                stack.push(c);
            }

            System.out.println("Stack: " + stack);
        }

        System.out.println(stack.empty());

    }
}
