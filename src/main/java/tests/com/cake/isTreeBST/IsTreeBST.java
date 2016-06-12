package tests.com.cake.isTreeBST;

import tests.com.cake.util.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by ishishov on 5/13/16.
 */
public class IsTreeBST {

    private static boolean isBST(BinaryTreeNode nodeUnBalanced) {

        Stack<NodeLowerUpper> nodes = new Stack();
        nodes.push(new NodeLowerUpper(nodeUnBalanced, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while(!nodes.empty()) {
            NodeLowerUpper nlu =  nodes.pop();
            BinaryTreeNode node = nlu.node;
            Integer lower = nlu.lower;
            Integer upper = nlu.upper;



            if (node.value < lower || node.value > upper) return false;

            if (node.left != null) {
                nodes.push(new NodeLowerUpper(node.left, lower, node.value));
            }

            if (node.right != null) {
                nodes.push(new NodeLowerUpper(node.right, node.value, upper));
            }

        }

        return true;
    }


    public static void main(String[] args) {
        BinaryTreeNode nodeBalanced = new BinaryTreeNode(5);
        nodeBalanced.insertLeft(2);
        nodeBalanced.insertRight(8);
        nodeBalanced.left.insertLeft(1);
        System.out.println(isBST(nodeBalanced));

        BinaryTreeNode nodeUnBalanced = new BinaryTreeNode(5);
        nodeUnBalanced.insertLeft(2);
        nodeUnBalanced.left.insertLeft(8);
        nodeUnBalanced.left.left.insertLeft(1);
        nodeUnBalanced.left.left.left.insertLeft(4);
        System.out.println(isBST(nodeUnBalanced));
    }

}
