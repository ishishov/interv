package tests.com.cake;

/**
 * Created by ishishov on 4/12/16.
 */
public class HourGlass {

    public static void main(String[] args) {

        int[][] a = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,7},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
        System.out.println(findMaxHourGlass(a));

    }

    private static int findMaxHourGlass(int[][] a) {

        int max = 0;

        for (int i = 0, sum=0; i<a.length-2; i++) {
            for (int j=0; j<a[0].length-2; j++) {
                sum = findSum(a,i,j);
                if (sum > max) max = sum;
            }
        }

        return max;
    }

    public static int findSum(int[][] a, int i, int j){
        return a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
    }

}
