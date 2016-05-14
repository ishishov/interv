package tests.com.cake.LinkedListLoop;

/**
 * Created by ishishov on 5/14/16.
 */
public class LinkedListLoop {

    public static void main(String[] args) {
        LinkedListNode nodeFullCycle = new LinkedListNode(1);
        nodeFullCycle.next = new LinkedListNode(2);
        nodeFullCycle.next.next = new LinkedListNode(3);
        nodeFullCycle.next.next.next = new LinkedListNode(4);
        nodeFullCycle.next.next.next.next = nodeFullCycle;
        System.out.println(hasCycle(nodeFullCycle));

        LinkedListNode nodeMidCycle = new LinkedListNode(1);
        nodeMidCycle.next = new LinkedListNode(2);
        nodeMidCycle.next.next = new LinkedListNode(3);
        nodeMidCycle.next.next.next = new LinkedListNode(4);
        nodeMidCycle.next.next.next.next = nodeMidCycle.next.next;
        System.out.println(hasCycle(nodeMidCycle));

        LinkedListNode nodeNoCycle = new LinkedListNode(1);
        nodeNoCycle.next = new LinkedListNode(2);
        nodeNoCycle.next.next = new LinkedListNode(3);
        nodeNoCycle.next.next.next = new LinkedListNode(4);
        System.out.println(hasCycle(nodeNoCycle));
    }

    private static boolean hasCycle(LinkedListNode node) {
        LinkedListNode slowRunner = node;
        LinkedListNode fastRunner = node;

        while (fastRunner!= null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (fastRunner == slowRunner) return true;
        }
        return false;
    }
}
