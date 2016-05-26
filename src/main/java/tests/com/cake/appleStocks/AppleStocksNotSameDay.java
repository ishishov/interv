package tests.com.cake.appleStocks;

import java.util.Arrays;

/**
 * Created by ishishov on 5/5/16.
 */
public class AppleStocksNotSameDay {

    private class Tuple {
        int profit, min, max;
        Tuple (int a, int b, int c) {
            this.profit = a; this.min = b; this.max =c;
        }
    }

    private int maxOf3(int a, int b, int c) {
        int[] arr = {a, b, c};
        return Arrays.stream(arr).max().getAsInt();
    }

    private int maxOfArray(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    private int minOfArray(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    private int[] leftHalf(int[]arr) {
        return Arrays.copyOfRange(arr, 0, arr.length/2);
    }

    private int[] rightHalf(int[]arr) {
        return Arrays.copyOfRange(arr, arr.length/2, arr.length);
    }

    //
    // Four different algorithms for solving the maximum single-sell profit problem,
    // each of which have different time and space complexity.  This is one of my
    // all-time favorite algorithms questions, since there are so many different
    // answers that you can arrive at by thinking about the problem in slightly
    // different ways.
    //
    // The maximum single-sell profit problem is defined as follows.  You are given
    // an array of stock prices representing the value of some stock over time.
    // Assuming that you are allowed to buy the stock exactly once and sell the
    // stock exactly once, what is the maximum profit you can make?  For example,
    // given the prices
    //
    //                        2, 7, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5
    //
    // The maximum profit you can make is 8, by buying when the stock price is 1 and
    // selling when the stock price is 9.  Note that while the greatest difference
    // in the array is 9 (by subtracting 9 - 0), we cannot actually make a profit of
    // 9 here because the stock price of 0 comes after the stock price of 9 (though
    // if we wanted to lose a lot of money, buying high and selling low would be a
    // great idea!)
    //
    // In the event that there's no profit to be made at all, we can always buy and
    // sell on the same date.  For example, given these prices (which might
    // represent a buggy-whip manufacturer:)
    //
    //                            9, 8, 7, 6, 5, 4, 3, 2, 1, 0
    //
    // The best profit we can make is 0 by buying and selling on the same day.

    // This solution is extremely inelegant, and it seems like there just *has* to
    // be a better solution.  In fact, there are many better solutions, and we'll
    // see three of them.
    //
    // The first insight comes if we try to solve this problem by using a divide-
    // and-conquer strategy.  Let's consider what happens if we split the array into
    // two (roughly equal) halves.  If we do so, then there are three possible
    // options about where the best buy and sell times are:
    //
    // 1. We should buy and sell purely in the left half of the array.
    // 2. We should buy and sell purely in the right half of the array.
    // 3. We should buy in the left half of the array and sell in the right half of
    //    the array.
    //
    // (Note that we don't need to consider selling in the left half of the array
    // and buying in the right half of the array, since the buy time must always
    // come before the sell time)
    //
    // If we want to solve this problem recursively, then we can get values for (1)
    // and (2) by recursively invoking the algorithm on the left and right
    // subarrays.  But what about (3)?  Well, if we want to maximize our profit, we
    // should be buying at the lowest possible cost in the left half of the array
    // and selling at the highest possible cost in the right half of the array.
    // This gives a very elegant algorithm for solving this problem:
    //
    //    If the array has size 0 or size 1, the maximum profit is 0.
    //    Otherwise:
    //       Split the array in half.
    //       Compute the maximum single-sell profit in the left array, call it L.
    //       Compute the maximum single-sell profit in the right array, call it R.
    //       Find the minimum of the first half of the array, call it Min
    //       Find the maximum of the second half of the array, call it Max
    //       Return the maximum of L, R, and Max - Min.
    //
    // Let's consider the time and space complexity of this algorithm.  Our base
    // case takes O(1) time, and in our recursive step we make two recursive calls,
    // one on each half of the array, and then does O(n) work to scan the array
    // elements to find the minimum and maximum values.  This gives the recurrence
    //
    //    T(1)     = O(1)
    //    T(n / 2) = 2T(n / 2) + O(n)
    //
    // Using the Master Theorem, this recurrence solves to O(n log n), which is
    // asymptotically faster than our original approach!  However, we do pay a
    // (slight) cost in memory usage.  Because we need to maintain space for all of
    // the stack frames we use.  Since on each recursive call we cut the array size
    // in half, the maximum number of recursive calls we can make is O(log n), so
    // this algorithm uses O(n log n) time and O(log n) memory.


    //nlogn time + nlogn memory
    public int getMaxProfit(int[] a) {
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        if (a.length < 2) return 0;
        int[] left = leftHalf(a);
        int[] right = rightHalf(a);

        int leftBest = getMaxProfit(left);
        int rightBest = getMaxProfit((right));
        int crossBest = maxOfArray(right) - minOfArray(left);

        return maxOf3(leftBest, rightBest, crossBest);
    }

    // While the above algorithm for computing the maximum single-sell profit is
    // better timewise than what we started with (O(n log n) versus O(n^2)), we can
    // still improve the time performance.  In particular, recall our recurrence
    // relation:
    //
    //    T(1) = O(1)
    //    T(n) = 2T(n / 2) + O(n)
    //
    // Here, the O(n) term in the T(n) case comes from the work being done to find
    // the maximum and minimum values in the right and left halves of the array,
    // respectively.  If we could find these values faster than what we're doing
    // right now, we could potentially decrease the function's runtime.
    //
    // The key observation here is that we can compute the minimum and maximum
    // values of an array using a divide-and-conquer approach.  Specifically:
    //
    //    If the array has just one element, it is the minimum and maximum value.
    //    Otherwise:
    //       Split the array in half.
    //       Find the minimum and maximum values from the left and right halves.
    //       Return the minimum and maximum of these two values.
    //
    // Notice that our base case does only O(1) work, and our recursive case manages
    // to do only O(1) work in addition to the recursive calls.  This gives us the
    // recurrence relation
    //
    //    T(1) = O(1)
    //    T(n) = 2T(n / 2) + O(1)
    //
    // Using the Master Theorem, this solves to O(n).
    //
    // How can we make use of this result?  Well, in our current divide-and-conquer
    // solution, we split the array in half anyway to find the maximum profit we
    // could make in the left and right subarrays.  Could we have those recursive
    // calls also hand back the maximum and minimum values of the respective arrays?
    // If so, we could rewrite our solution as follows:
    //
    //    If the array has size 1, the maximum profit is zero and the maximum and
    //       minimum values are the single array element.
    //    Otherwise:
    //       Split the array in half.
    //       Compute the maximum single-sell profit in the left array, call it L.
    //       Compute the maximum single-sell profit in the right array, call it R.
    //       Let Min be the minimum value in the left array, which we got from our
    //           first recursive call.
    //       Let Max be the maximum value in the right array, which we got from our
    //           second recursive call.
    //       Return the maximum of L, R, and Max - Min for the maximum single-sell
    //           profit, and the appropriate maximum and minimum values found from
    //           the recursive calls.
    //
    // The correctness proof for this algorithm works just as it did before, but now
    // we never actually do a scan of the array at each step.  In fact, we do only
    // O(1) work at each level.  This gives a new recurrence
    //
    //     T(1) = O(1)
    //     T(n) = 2T(n / 2) + O(1)
    //
    // Which solves to O(n).  We're now using O(n) time and O(log n) memory, which
    // is asymptotically faster than before!
    //
    // The code for this is given below:



    //n time + log(n) memory
    public int getMaxProfitOptimized(int[] arr) {
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        if (arr.length < 1) return 0;
        return getMaxProfitOptimizedRec(arr, 0, arr.length - 1).profit;
    }

    private Tuple getMaxProfitOptimizedRec(int[] arr, int left, int right) {
        if (left == right) return new Tuple(0, arr[left], arr[right]);
        int mid = left + (right - left) / 2;
        Tuple leftTuple = getMaxProfitOptimizedRec(arr, left, mid);
        Tuple rightTuple = getMaxProfitOptimizedRec(arr, mid + 1, right);
        int maxProfit = maxOf3(leftTuple.profit, rightTuple.profit, rightTuple.max - leftTuple.min);
        return new Tuple(maxProfit, Math.min(leftTuple.min, rightTuple.min), Math.max(leftTuple.max, rightTuple.max));
    }

    // At this point we've traded our O(n^2)-time, O(1)-space solution for an O(n)-
    // time, O(log n) space solution.  But can we do better than this?
    //
    // To find a better algorithm, we'll need to switch our line of reasoning.
    // Rather than using divide-and-conquer, let's see what happens if we use
    // dynamic programming.  In particular, let's think about the following problem.
    // If we knew the maximum single-sell profit that we could get in just the first
    // k array elements, could we use this information to determine what the
    // maximum single-sell profit would be in the first k + 1 array elements?  If we
    // could do this, we could use the following algorithm:
    //
    //   Find the maximum single-sell profit to be made in the first 1 elements.
    //   For i = 2 to n:
    //      Compute the maximum single-sell profit using the first i elements.
    //
    // How might we do this?  One intuition is as follows.  Suppose that we know the
    // maximum single-sell profit of the first k elements.  If we look at k + 1
    // elements, then either the maximum profit we could make by buying and selling
    // within the first k elements (in which case nothing changes), or we're
    // supposed to sell at the (k + 1)st price.  If we wanted to sell at this price
    // for a maximum profit, then we would want to do so by buying at the lowest of
    // the first k + 1 prices, then selling at the (k + 1)st price.
    //
    // To accomplish this, suppose that we keep track of the minimum value in the
    // first k elements, along with the maximum profit we could make in the first
    // k elements.  Upon seeing the (k + 1)st element, we update what the current
    // minimum value is, then update what the maximum profit we can make is by
    // seeing whether the difference between the (k + 1)st element and the new
    // minimum value is.  Note that it doesn't matter what order we do this in; if
    // the (k + 1)st element is the smallest element so far, there's no possible way
    // that we could increase our profit by selling at that point.
    //
    // To finish up this algorithm, we should note that given just the first price,
    // the maximum possible profit is 0.
    //
    // This gives the following simple and elegant algorithm for the maximum single-
    // sell profit problem:
    //
    //   Let profit = 0.
    //   Let min = arr[0]
    //   For k = 1 to length(arr):
    //       If arr[k] < min, set min = arr[k]
    //       If profit < arr[k] - min, set profit = arr[k] - min
    //
    // This is short, sweet, and uses only O(n) time and O(1) memory.  The beauty of
    // this solution is that we are quite naturally led there by thinking about how
    // to update our answer to the problem in response to seeing some new element.
    // In fact, we could consider implementing this algorithm as a streaming
    // algorithm, where at each point in time we maintain the maximum possible
    // profit and then update our answer every time new data becomes available.
    //
    // The final version of this algorithm is shown here:

    //n time + 1 memory
    public int getMaxProfitDynamic(int[] arr) {
        int[] salesmid = {1, 4, 7, 5, 3, 2, 10, 7};
        if (arr.length < 1) return 0;
        int profit = arr[1] - arr[0];
        int min = arr[0];
        int minIndex = 0;
        for (int i=1; i < arr.length; i++) {
            if (min > arr[i]) {
                minIndex = i;
                min = arr[i];
            }
            if(minIndex != i)
            profit = Math.max(profit, arr[i] - min);
        }

        return profit;
    }

    // To summarize our algorithms, we have seen
    //
    // Naive:                        O(n ^ 2)   time, O(1)     space
    // Divide-and-conquer:           O(n log n) time, O(log n) space
    // Optimized divide-and-conquer: O(n)       time, O(log n) space
    // Dynamic programming:          O(n)       time, O(1)     space

}
