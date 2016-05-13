package tests.com.cake;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ishishov on 5/13/16.
 */
public class TemperatureTracker {

    Map<Integer, Integer> counts = new HashMap();
    Integer max;
    Integer min;
    Integer mode;
    Integer size = 0;
    Integer sum = 0;

    @Override
    public String toString() {
        return "TemperatureTracker{" +
                " max=" + max +
                " min=" + min +
                " mode=" + mode +
                " mean=" + getMean() +
                " }";
    }

    public void insert(Integer a) {
        size ++;
        sum +=a;
        if (max == null || a > max) max = a;
        if (min == null || a < min) min = a;
        if (!counts.containsKey(a)) counts.put(a, 1);
        else counts.put(a, counts.get(a) + 1);
        if (mode == null || counts.get(a) > mode) mode = a;
        System.out.println("Inserting  " + a + "  " + this);
    }

    public Double getMean() {
        return (double) sum / size;
    }

    public Integer getMode() {
        return mode;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {

        return max;
    }

    public static void main(String[] args) {
        TemperatureTracker a = new TemperatureTracker();
        a.insert(1);
        a.insert(2);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(4);
        a.insert(4);

    }

}
