package tests.com.sorts;

import java.util.Arrays;

/**
 * Created by ishishov on 5/15/16.
 */
public class CountingSort {

    public static void main (String[] args) {
        int[] a = {1, 5, 11, 42, 1, 64, 64, 15, 31, 22};

        System.out.println(Arrays.toString(countingSort(a, 100)));
    }

    private static int[] countingSort(int[] a, int max) {

        int[] counts = new int[max+1];

        for(int i=0; i < a.length; i++) {
            counts[a[i]]++;
        }

        int[] sortedArray = new int[a.length];
        int currentIndex = 0;
        for (int i=0; i < counts.length; i++) {
            int count = counts[i];
            for (int j=0 ; j<count; j++)  {
                sortedArray[currentIndex++] = i;
            }
        }



        return sortedArray;
    }


}
