package tests.com.cake;

import java.util.*;

/**
 * Created by ishishov on 5/12/16.
 */
public class MakingChange {

    public static void main(String[] args) {
        int[] den = {1,2,3};
        int sum = 4;
        //System.out.println(makeChange(sum));
        System.out.println(changeCountRecursive(sum, den, 0));
        System.out.println(changeCountTopDown(sum,den));
        System.out.println(changeCountBottomUp(sum, den));

    }

    public static Integer changeCountRecursive(int n, int[] v, int i) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
    // means coins over and n>0 so no solution
        if (i == v.length && n > 0) {
            return 0;
        }
        return changeCountRecursive(n - v[i], v, i) + changeCountRecursive(n, v, i + 1);
    }

    // recursion with memoizing.
    // O(n*m) time, O(n*m) space
    static Map<String, Integer> memo = new HashMap<String, Integer>();

    public static int changeCountTopDown(int amountLeft, int[] denominationsLeft) {
        // check our memo and short-circuit if we've already solved this one
        String memoKey = amountLeft + " " + Arrays.toString(denominationsLeft);
        if (memo.containsKey(memoKey)) {
            System.out.println("grabbing memo[" + memoKey + "]");
            return memo.get(memoKey);
        }

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) return 1;

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) return 0;

        // we're out of denominations
        if (denominationsLeft.length == 0) return 0;

        System.out.println("checking ways to make " + amountLeft + " with " + Arrays.toString(denominationsLeft));

        // choose a current coin
        int current_coin = denominationsLeft[0];
        int[] restOfCoins = Arrays.copyOfRange(denominationsLeft, 1, denominationsLeft.length);

        // see how many possibilities we can get
        // for each number of times to use current_coin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changeCountTopDown(amountLeft, restOfCoins);
            amountLeft -= current_coin;
        }

        // save the answer in our memo so we don't compute it again
        memo.put(memoKey, numPossibilities);
        return numPossibilities;
    }


    // O(n*m) time, O(n) space

    /*
    However, we can do better. Because our function is recursive it will build up a large call stack ↴ ngInclude: conceptPartialUrl of size
    O(m)O(m)
    O(m). Of course, this cost is eclipsed by the memory cost of memo, which is
    O(n∗m)O(n*m)
    O(n∗m). But it's still best to avoid building up a large stack like this, because it can cause a stack overflow (yes, that means recursion is usually better to avoid for functions that might have arbitrarily large inputs).
    It turns out we can get
    O(n)O(n)
    O(n) additional space.
    A great way to avoid recursion is to go bottom-up ↴ ngInclude: conceptPartialUrl .
    Our recursive approach was top-down because it started with the final value for amount and recursively broke the problem down into subproblems with smaller values for amount. What if instead we tried to compute the answer for small values of amount first, and use those answers to iteratively compute the answer for higher values until arriving at the final amount?
    We can start by making an array waysOfDoingNCents, where the index is the amount and the value at each index is the number of ways of getting that amount.
    This array will take
    O(n)O(n)
    O(n) space, where
    nn
    n is the size of amount.
    To further simplify the problem, we can work with only the first coin in denominations, then add in the second coin, then the third, etc.
    What would waysOfDoingNCents look like for just our first coin: 1¢? Let's call this waysOfDoingNCents1.
    int[] waysOfDoingNCents1 = new int[]{
            1,  // 0c:  no coins
            1,  // 1c:  1 1c coin
            1,  // 2c:  2 1c coins
            1,  // 3c:  3 1c coins
            1,  // 4c:  4 1c coins
            1,  // 5c:  5 1c coins
    }
    PythonRubyJavaJavaScript
    FE TESTING <button class="run-tests" ng-show="showTests && hasTests" ng-click="runTests()">TEST</button>
    Now what if we add a 2¢ coin?
    int[] waysOfDoingNCents1And2 = new int[]{
            1,    // 0c:  no change
            1,    // 1c:  no change
            1+1,  // 2c:  new [(2)]
            1+1,  // 3c:  new [(2,1)]
            1+2,  // 4c:  new [(2,1,1), (2,2)]
            1+2,  // 5c:  new [(2,1,1,1), (2,2,1)]
    }
    PythonRubyJavaJavaScript
    FE TESTING <button class="run-tests" ng-show="showTests && hasTests" ng-click="runTests()">TEST</button>
    How do we formalize this process of going from waysOfDoingNCents1 to waysOfDoingNCents1And2?
    Let's suppose we're partway through already (this is a classic dynamic programming approach). Say we're trying to calculate waysOfDoingNCents1And2[5]. Because we're going bottom-up, we know we already have:
            1. waysOfDoingNCents1And2 for amounts less than 5 5  5
            2. a fully-populated waysOfDoingNCents1
    So how many new ways should we add to waysOfDoingNCents1[5] to get waysOfDoingNCents1And2[5]?
    Well, if there are any new ways to get 5¢ now that we have 2¢ coins, those new ways must involve at least one 2¢ coin. So if we presuppose that we'll use one 2¢ coin, that leaves us with
            5
            −
            2
            =
            3
            5-2=3
            5−2=3 left to come up with. We already know how many ways we can get 3¢ with 1¢ and 2¢ coins: waysOfDoingNCents1And2[3], which is
    2
            2
            2.
    So we can see that:
    waysOfDoingNCents1And2[5] = waysOfDoingNCents1[5] + waysOfDoingNCents1And2[5-2]
    PythonRubyJavaJavaScript
    FE TESTING <button class="run-tests" ng-show="showTests && hasTests" ng-click="runTests()">TEST</button>
    Why don't we also need to check waysOfDoingNCents1And2[5 - 2 - 2] (two 2¢ coins)? Because we already checked waysOfDoingNCents1And2[1] when calulating waysOfDoingNCents1And2[3]. We'd be counting some arrangements multiple times. In other words, waysOfDoingNCents1And2[k] already includes the full count of possibilities for getting
            kk
    k, including possibilities that use 2¢ any number of times. We're only interested in how many more possibilities we might get when we go from
    kk
    k to
    k+
            2
    k+2
    k+2 and thus have the ability to add one more 2¢ coin to each of the possibilities we have for
    kk
    k.
            Solution
    We use a bottom-up ↴ ngInclude: conceptPartialUrl algorithm to build up a table waysOfDoingNCents such that waysOfDoingNCents[k] is how many ways we can get to k cents using our denominations. We start with the base case that there's one way to create the amount zero, and progressively add each of our denominations.
    The number of new ways we can make a higherAmount when we account for a new coin is simply waysOfDoingNCents[higherAmount - coin], where we know that value already includes combinations involving coin (because we went bottom-up, we know smaller values have already been calculated).
*/
    public static int changeCountBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount+1]; // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount < amount + 1; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }
}
