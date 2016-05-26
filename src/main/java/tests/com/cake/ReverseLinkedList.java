package tests.com.cake;

import sun.awt.image.ImageWatched;
import tests.com.cake.util.LinkedListNode;

/**
 * Created by ishishov on 5/14/16.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        node.next = new LinkedListNode(2);
        node.next.next = new LinkedListNode(3);
        node.next.next.next = new LinkedListNode(4);
    }

    public static LinkedListNode reverse(LinkedListNode node) {
        LinkedListNode current = node;
        LinkedListNode prev = null;
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}
