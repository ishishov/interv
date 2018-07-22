package tests.com.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishishov on 4/2/17.
 */
public class FromBstToArray {
    public static void main(String[] args) {

        Node bst = new Node(5, new Node(2, new Node(1), new Node(3)), new Node(7, new Node(6), new Node(8)));
        List<Integer> result = fromBstToArray(bst);
        System.out.println(result);
    }

    static List<Integer> fromBstToArray(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null)
            result.addAll(fromBstToArray(root.left));
        result.add(root.value);
        if (root.right != null)
            result.addAll(fromBstToArray(root.right));
        return result;
    }

    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString(){
            return "<" +toString(this) + ">";
        }

        public static String toString(Node r){
            if(r==null)
                return "";
            else
                return toString(r.left) + " " +r.value + " " +toString(r.right);
        }
    }
}
