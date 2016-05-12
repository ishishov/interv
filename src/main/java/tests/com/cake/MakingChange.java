package tests.com.cake;

import java.util.*;

/**
 * Created by ishishov on 5/12/16.
 */
public class MakingChange {

    static int sum = 4;

    public static void main(String[] args) {
        Integer[] den = {1,2,3};

        //System.out.println(makeChange(sum));
        System.out.println(makeChangeRecursive(Arrays.asList(den), 0,new ArrayList(), new ArrayList()));

    }

    private static List<List<Integer>> makeChangeRecursive(List<Integer> den, int total, List<Integer> used, List<List<Integer>> all) {
        if(total > sum) return null;
        if(total == sum) {all.add(used); return all;}

        for (int i=0; i<den.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = den.get(i);
            for (int j=i+1; j<den.size();j++) remaining.add(den.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(used);
            partial_rec.add(n);
            return makeChangeRecursive(remaining, total + den.get(i), partial_rec, all);

        }

        return all;
    }

    private static List<List<Integer>> makeChange(int sum) {
        List<List<Integer>> result = new ArrayList();

        for (int m = 0; m < 0; m++)
            sum = 20;
            while(sum >= 0) {

                if (sum == 0);
            }

        return result;
    }
}
