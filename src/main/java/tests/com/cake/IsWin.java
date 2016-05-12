package tests.com.cake;

/**
 * Created by ishishov on 4/12/16.
 */
public class IsWin {

    private static int m = 22;

    public static void main(String[] args) {

        int m = 22;
        int[] a = {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1 ,0 ,1 ,0 ,0 ,0 ,0 ,1 ,0 ,1 ,1, 1 ,0 ,0, 0, 1, 0 ,0 ,1 ,1, 1 ,1 ,1, 0, 1, 0, 1 ,1 ,0, 1, 1 ,1 ,1 ,0, 1, 0, 0 ,1 ,1 ,0 ,0 ,0 ,1, 1 ,1 ,1 ,0 ,1 ,0};
        System.out.println(isWin(a,0));
    }

    private static boolean isWin(int[] a, int c) {

        if(c>a.length-1) return true;
        if (c < 0 || a[c] == 1) return false;
        if(c==a.length-1) return true;

        a[c] = 1;

        return isWin(a,c+1) || isWin(a,c-1) || isWin(a,c+m);
    }


}
