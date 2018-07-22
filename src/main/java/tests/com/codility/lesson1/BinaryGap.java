package tests.com.codility.lesson1;


public class BinaryGap {
    public int solution(int N) {
        int result = 0;
        int count = 0;
        while (N%2 != 1 && N > 0) N = N >> 1;
        while (N > 0) {
            if (N%2 == 1) {
                result = Math.max(result, count);
                count = 0;
            } else {
                count++;
            }
            N = N >> 1;
        }
        return result;
    }
}
