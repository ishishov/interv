package tests.com.codility.lesson10;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class CountFactors {
    public int solution(int n) {
        int i=1;
        int cnt = 0;
        while(i <= Math.sqrt(n))
        {
            if (n % i == 0) {
                cnt++;
                if (i != (n / i)) {
                    cnt++;
                }
            }
            i++;
        }
        return cnt;
    }
}