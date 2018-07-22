package tests.com.codility.lesson2;

/**
 * Created by ishishov on 6/19/16.
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}
