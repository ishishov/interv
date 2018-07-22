package tests.com.others;

/**
 * Created by ishishov on 4/2/17.
 */
public class FromArrayToBstUnbalanced {

    public static void main(String[] args) {
        int[] values = {5, 6, 2, 3, 1, 4};
        Node bst = fromArrayToBst(values);

        System.out.print(bst);
    }

    static Node fromArrayToBst(int[] values) {
        return new Node(5, new Node(4), new Node(6));
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
