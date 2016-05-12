package tests.com.cake;

import java.util.Stack;

/**
 * Created by ishishov on 4/12/16.
 */
public class StackTest {

    public static void main(String[] args) {

        String s = "{}{()}{}}";

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (Character c : chars){
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
