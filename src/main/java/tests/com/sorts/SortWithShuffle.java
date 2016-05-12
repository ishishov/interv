package tests.com.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ishishov on 5/11/16.
 */
public class SortWithShuffle {
    public static void main(String[] args) {
        int[] x = new int[10000000];
        for(int i=0;i<x.length;i++){
            //x[i] = new Random().nextInt(); //rand
            x[i] = i; // sorted
            //x[i] = x.length - i;//descending
        }
        //System.out.println(Arrays.toString(x));
        int[] x1 = Arrays.copyOf(x, x.length);
        int[] x2 = Arrays.copyOf(x, x.length);

        int low = 0;
        int high = x.length - 1;

        long current1 = System.currentTimeMillis();
        quickSort(x1, low, high);
        System.out.println(System.currentTimeMillis() - current1);

        long current2 = System.currentTimeMillis();
        shuffleArray(x2);
        quickSort(x2, low, high);
        System.out.println(System.currentTimeMillis() - current2);
    }

    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

}