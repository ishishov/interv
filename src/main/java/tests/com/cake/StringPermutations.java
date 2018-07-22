package tests.com.cake;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ishishov on 5/15/16.
 */
public class StringPermutations {


    public static void main(String[] args) {

        String s = "abc";
        Set<String> set = new HashSet<>();
        set.add(s.substring(0 ,1));

        System.out.println(showPermutations(s, set, 1));


    }

    private static Set<String> showPermutations(String s, Set<String> set, int k) {

        if(k == s.length()) return set;

        Set<String> newSet = new HashSet<>();

        char c = s.charAt(k);
        for (String st : set) {
            for(int i = 0; i<=st.length(); i++) {
                String a = st.substring(0, i) + c + st.substring(i, st.length());
                newSet.add(a);
            }

        }

        return showPermutations(s, newSet, k+1);
    }
}
