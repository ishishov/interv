package tests.com.cake.superbalancedtree.recursive;


import tests.com.cake.util.BinaryTreeNode;

/**
 * Created by ishishov on 5/13/16.
 */
public class SuperBalancedTree {

    public static int getMaxDepth(BinaryTreeNode root, int count) {
        if (root == null) return count;
        return Math.max(getMaxDepth(root.left, count+1), getMaxDepth(root.right, count+1));
    }

    public static int getMinDepth(BinaryTreeNode root, int count) {
        if (root == null) return count;
        return Math.min(getMaxDepth(root.left, count+1), getMaxDepth(root.right, count+1));
    }

    public static boolean isSuperBalanced(BinaryTreeNode root) {
        return (getMaxDepth(root,0) - getMinDepth(root,0) < 2);
    }

    public static void main(String[] args) {
        BinaryTreeNode nodeBalanced = new BinaryTreeNode(5);
        nodeBalanced.insertLeft(2);
        nodeBalanced.insertRight(8);
        nodeBalanced.left.insertLeft(1);
        System.out.println(getMaxDepth(nodeBalanced, 0));
        System.out.println(isSuperBalanced(nodeBalanced));

        BinaryTreeNode nodeUnBalanced = new BinaryTreeNode(5);
        nodeUnBalanced.insertLeft(2);
        nodeUnBalanced.left.insertLeft(8);
        nodeUnBalanced.left.left.insertLeft(1);
        nodeUnBalanced.left.left.left.insertLeft(4);
        System.out.println(getMaxDepth(nodeUnBalanced, 0));
        System.out.println(isSuperBalanced(nodeUnBalanced));
    }

}
