package tests.com.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ishishov on 6/27/16.
 */
public class RobotSelfAvoidingWalk {
    static int m = 7;

    public static void main(String[] args) {
        int[][] a = new int[m][m];
        a[0][0] = 1;

        //System.out.println(SelfAvoidingPathsMap);
        //System.out.println(findPaths(0, 0, a));
        System.out.println(2* findPaths(0, 1, a));
    }

    static int findPaths(int i, int j, int[][] arr) {

        if (i == m-1 && j == m-1) return 1;
        if (i < 0 || j < 0 || i >= m || j >= m) return 0;
        if (arr[i][j] == 1) return 0;

        int [][] arrCpy = new int[m][m];

        for(int k = 0; k < arr.length; k++)
            arrCpy[k] = arr[k].clone();

        arrCpy[i][j] = 1;
        return findPaths(i-1, j, arrCpy) + findPaths(i+1, j, arrCpy) + findPaths(i, j-1, arrCpy) + findPaths(i, j+1, arrCpy);
    }

}
