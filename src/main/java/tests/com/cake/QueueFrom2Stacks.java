package tests.com.cake;

import java.util.Stack;

/**
 * Created by ishishov on 5/14/16.
 */
public class QueueFrom2Stacks {

    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack();

    void enqueue(Integer i){
        in.push(i);
        System.out.println(in);
        System.out.println(out);
        System.out.println();
    }

    Integer dequeue() {
        if (out.isEmpty()) {
            while(!in.isEmpty())
                out.push(in.pop());
            }
        Integer a = out.pop();
        System.out.println(in);
        System.out.println(out);
        System.out.println();
        return a;
    }

    public static void main (String[] args) {
        QueueFrom2Stacks q = new QueueFrom2Stacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.dequeue();
        q.enqueue(6);
        q.dequeue();
    }

}
