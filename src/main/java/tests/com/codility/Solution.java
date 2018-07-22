package tests.com.codility;

import java.util.*;

/**
 * Created by ishishov on 6/12/16.
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {4, 6, 4, 3, 6, 6, 1}; // 4
        int[] a2 = { 1, 2, 3, 7, 4, 5, 1, 10}; //
        //System.out.println(solution2(a));
        //System.out.println(solution3(a2));
        System.out.println(solution5("ab0000acc1a"));

    }
/*
    static int solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }*/

    static int solution2(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        for (int i=0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                result = Math.max(result, i - map.get(A[i]));
            }
            else {
                map.put(A[i], i);
            }
        }
        return result;
    }

    static int solution3(int[] A) {
        int[] sortedA = Arrays.copyOf(A, A.length);
        Arrays.sort(sortedA);
        int startIndex = 0;
        int endIndex = A.length - 1;

        while (startIndex < A.length) {
            if (A[startIndex] != sortedA[startIndex]) {
                break;
            }
            startIndex++;
        }

        if (startIndex == A.length) {
            return 0;
        } else {
            while (endIndex > 0) {
                if (A[endIndex] != sortedA[endIndex]) {
                    break;
                }
                endIndex--;
            }
        }

        return endIndex-startIndex + 1;
    }

    static int solution4(String s) {
        int result = -1;
        boolean hasCaps = false;
        for (int i=0; i<s.length(); i++) {
            while (isDigit(s.charAt(i))) {
                i++;
            }
            int startIndex = i;
            char c = s.charAt(i);
            if (!isDigit(c)) {
                if (!hasCaps) {
                    hasCaps = isCaps(c);
                }
            } else {
                if (hasCaps) {
                    result = Math.max(result, i - startIndex);
                }
                while (isDigit(s.charAt(i))) {
                    i++;
                }
            }
        }
        return result;
    }

    static int solution5(String st) {
        int result = -1;
        String[] subStrings = st.split("\\d+");
        for (String s : subStrings) {
            if (hasCaps(s)) {
                result = Math.max(result, s.length());
            }
        }
        return result;
    }

    static boolean isCaps(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean hasCaps(String s) {
        for (int i = 0; i< s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}
