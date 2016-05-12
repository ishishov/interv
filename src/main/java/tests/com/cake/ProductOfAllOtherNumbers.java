package tests.com.cake;

import java.util.Arrays;

/**
 * Created by ishishov on 5/12/16.
 */
public class ProductOfAllOtherNumbers {



    public static void main(String[] args) {

        int[] arr = {1,0,3,0};

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(findProductOfAllOther(arr)));


    }

    private static int[] findProductOfAllOther(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        int p = 1;
        for (int i=0; i<arr.length; i++) {
            result[i] *= p;
            p*=arr[i];
        }

        p=1;
        for (int i=arr.length-1; i>=0; i--) {
            result[i] *=p;
            p*=arr[i];
        }

        return result;
    }
}