package tests.com.cake.superbalancedtree.iterative;

import tests.com.cake.superbalancedtree.BinaryTreeNode;

import java.util.*;

/**
 * Created by ishishov on 5/13/16.
 */
public class SuperBalancedTree {


    public static boolean isSuperBalanced(BinaryTreeNode root) {
        List<Integer> depths = new ArrayList(3);
        Stack<NodeWithDepth> nodes = new Stack();
        nodes.push(new NodeWithDepth(root, 0));

        while (!nodes.isEmpty()){
            NodeWithDepth nwd = nodes.pop();
            BinaryTreeNode node = nwd.node;

            if(node.left == null && node.right == null && !depths.contains(nwd.depth)) {
                depths.add(nwd.depth);
                if(depths.size() > 3) return false;
                if(depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1) return false;
            }
            else {
                if (node.left != null) nodes.push(new NodeWithDepth(node.left, nwd.depth + 1));
                if (node.right != null) nodes.push(new NodeWithDepth(node.right, nwd.depth + 1));
            }
        }
        return depths.size() == 2;
    }

    public static void main(String[] args) {
        BinaryTreeNode nodeBalanced = new BinaryTreeNode(5);
        nodeBalanced.insertLeft(2);
        nodeBalanced.insertRight(8);
        nodeBalanced.left.insertLeft(1);
        System.out.println(isSuperBalanced(nodeBalanced));

        BinaryTreeNode nodeUnBalanced = new BinaryTreeNode(5);
        nodeUnBalanced.insertLeft(2);
        nodeUnBalanced.left.insertLeft(8);
        nodeUnBalanced.left.left.insertLeft(1);
        nodeUnBalanced.left.left.left.insertLeft(4);
        System.out.println(isSuperBalanced(nodeUnBalanced));
    }

}
