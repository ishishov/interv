package tests.com.cake;

import java.util.Arrays;

/**
 * Created by ishishov on 5/12/16.
 */
public class HighestProductOf3 {
    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 9, -10};

        System.out.println(Arrays.toString(arr));
        System.out.println(highestProductOf3(arr));

    }

    private static int highestProductOf3(int[] arr) {
        int h1 = Integer.MIN_VALUE;
        int h2 = Integer.MIN_VALUE;
        int h3 = Integer.MIN_VALUE;
        int l1 = Integer.MAX_VALUE;
        int l2 = Integer.MAX_VALUE;

        for (int i=0; i< arr.length; i++) {
            if (arr[i] > h1) {
                h3 = h2;
                h2 = h1;
                h1 = arr[i];
            } else if (arr[i] > h2) {
                h3 = h2;
                h2 = arr[i];
            } else if (arr[i] > h3) {
                h3 = arr[i];
            }

            if (arr[i] < l1) {
                l2 = l1;
                l1 = arr[i];
            } else if (arr[i] < l2) {
                l2 = arr[i];
            }
        }

        return Math.max(h1 * h2 * h3, h1 * l1 * l2);
    }
}
