package tests.com.cracking.Bit;

/**
 * Created by ishishov on 5/17/16.
 * Input:N=10000000000, M=10011, i =2, j =6 Output: N = 10001001100
 */
public class InsertMtoN {

    public static void main(String[] args) {
        int i=3;
        int j=7;
        int n=100000000;
        int m=10001;

        int allOnes = ~0;
        int left = allOnes << (j+1);
        int right = (1<<i)-1;
        int mask = left | right;

        int cleanN = n & mask;
        int m1 = m << i;

        int result = m1 | cleanN;

        System.out.println("n = " + Integer.toBinaryString(n));
        System.out.println("m = " + Integer.toBinaryString(m));
        System.out.println("result = " + Integer.toBinaryString(result));
    }
}

