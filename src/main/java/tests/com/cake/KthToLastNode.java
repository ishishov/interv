package tests.com.cake;

import tests.com.cake.util.LinkedListNode;

/**
 * Created by ishishov on 5/14/16.
 */
public class KthToLastNode {

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        node.next = new LinkedListNode(2);
        node.next.next = new LinkedListNode(3);
        node.next.next.next = new LinkedListNode(4);
        node.next.next.next.next = new LinkedListNode(5);
        node.next.next.next.next.next = new LinkedListNode(6);

        //System.out.println(findKthToLast(null, 2));
        //System.out.println(findKthToLast(node, 22));
        System.out.println(findKthToLast(node, 2));
    }

    private static LinkedListNode findKthToLast(LinkedListNode node, int k) {
        if (node == null) {
            return null;
        }

        int count = 0;
        LinkedListNode low = node;
        LinkedListNode current = node;
        while (current != null) {
            current = current.next;
            if (count >= k) {
                low = low.next;
            }
            count++;
        }

        if (count < k) {
            return null;
        }

        return low;
    }

}
