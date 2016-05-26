package tests.com.cake;

/**
 * Created by ishishov on 5/15/16.
 */
public class Parentheticals {


    private static int findClosingP(String s, int k) {
        if (s.charAt(k) != '(') throw new RuntimeException();
        int position = k+1;
        int countOpened = 0;
        while (position<s.length()) {
            if (s.charAt(position) == '(')
                countOpened++;
            else if (s.charAt(position) == ')') {
                if (countOpened > 0) countOpened --;
                else return position;
            }
            position ++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "asd(das(()(())da)s)da()";

        System.out.println(findClosingP(s,3));
    }


}
