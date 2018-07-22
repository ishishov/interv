package tests.com.others;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ishishov on 4/2/17.
 */
public class FromArrayToBstBalanced {

    public static void main(String[] args) {
        int[] values = {5, 6, 2, 3, 1, 4};
        Arrays.sort(values);
        Node bst = fromSortedArrayToBst(values, 0, values.length -1);

        System.out.print(bst);
    }

    static Node fromSortedArrayToBst(int[] values, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node root = new Node(values[mid]);
        root.left = fromSortedArrayToBst(values, start, mid -1);
        root.right = fromSortedArrayToBst(values, mid +1, end);
        return root;
    }

    static class Node {
        int value;
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
