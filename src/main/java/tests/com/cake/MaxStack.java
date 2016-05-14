package tests.com.cake;

import java.util.Stack;

/**
 * Created by ishishov on 5/14/16.
 */
public class MaxStack extends Stack<Integer> {

    Stack<Integer> maxStack = new Stack();

    public Integer getMax() {
        return maxStack.peek();
    }

    @Override
    public Integer push(Integer a) {
        if (maxStack.isEmpty() || a >= maxStack.peek())
            maxStack.push(a);
        return super.push(a);
    }

    @Override
    public Integer pop() {
        if (peek() == maxStack.peek())
            maxStack.pop();
        return super.pop();
    }

    public static void main (String[] args) {
        MaxStack s = new MaxStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(4);
        System.out.println(s.getMax());
        s.pop();

        System.out.println(s.getMax());
        s.pop();
        System.out.println(s.getMax());
        s.pop();
        System.out.println(s.getMax());

    }
}
