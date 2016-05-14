package tests.com.cake.BSTsecondLargest;

/**
 * Created by ishishov on 5/14/16.
 */
public class BSTsecondLargest {

    public static int findSecondLargest(BinaryTreeNode root) {
        if (root.right == null) return root.left.value;
        BinaryTreeNode parent = null;
        while (root.right != null) {
            parent = root;
            root = root.right;
        }
        if (root.left == null) return parent.value;
        else return findLargestNode(root.left).value;

    }

    public static BinaryTreeNode findLargestNode(BinaryTreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
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
