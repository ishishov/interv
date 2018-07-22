package tests.com.codility.lesson3;

/**
 * Created by ishishov on 6/19/16.
 */
public class FrogJump {
    public int solution(int X, int Y, int D) {
        int total = Y - X;
        if ( total%D == 0)
            return total/D;
        return total/D+1;
    }
}
