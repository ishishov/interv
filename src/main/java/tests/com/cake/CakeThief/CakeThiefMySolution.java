package tests.com.cake.CakeThief;

import java.util.Arrays;

/**
 * Created by ishishov on 5/14/16.
 */
public class CakeThiefMySolution {

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(0, 0),
        };

        int capacity = 20;

        System.out.print(maxDuffelBagValue(cakeTypes, capacity));
    }

    private static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        System.out.println(Arrays.toString(cakeTypes));
        Arrays.sort(cakeTypes);
        System.out.println(Arrays.toString(cakeTypes));
        int i = 0;
        int value = 0;
        while (capacity >0 && i<cakeTypes.length) {
            int w = cakeTypes[i].weight;
            if (w > 0) {
                int a = capacity / w;
                value += cakeTypes[i].value * a;
                capacity -= a * w;
            }
            i++;
        }

        return value;
    }
}

