package tests.com.cake.util;

/**
 * Created by ishishov on 5/14/16.
 */
public class LinkedListNode {
    public Integer value;
    public LinkedListNode next;

    public LinkedListNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + value + ")";
    }
}
