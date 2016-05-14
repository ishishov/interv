package tests.com.cake.BSTsecondLargest;

/**
 * Created by ishishov on 5/14/16.
 */
public class BSTsecondLargestCakeSolution {

    public static int findLargest(BinaryTreeNode rootNode) {

        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode.left == null && rootNode.right == null) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }
        BinaryTreeNode current = rootNode;
        while (true) {
            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }
            // case: current ¡is parent of largest, and
            // largest has no children, so
            // current is 2nd largest
            if (current.right != null && current.right.left == null && current.right.right == null) {
                return current.value;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        node1.insertLeft(2);
        node1.insertRight(8);
        node1.right.insertRight(9);
        node1.right.right.insertRight(10);
        node1.left.insertLeft(1);
        System.out.println(findSecondLargest(node1));

        BinaryTreeNode node2 = new BinaryTreeNode(5);
        node2.insertLeft(2);
        node2.insertRight(8);
        node2.right.insertRight(12);
        node2.right.right.insertLeft(10);
        node2.right.right.left.insertRight(11);
        node2.left.insertLeft(1);
        System.out.println(findSecondLargest(node2));

    }
}
