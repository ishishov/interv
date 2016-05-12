package tests.com.cake;

import java.util.*;

/**
 * Created by ishishov on 5/12/16.
 */
public class HiCal {

    static class Meeting {
        public int start = 0;
                public int end = 0;
        public Meeting(int a, int b) {
            start = a; end = b;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static void main(String[] args) {

        Meeting[] arr = {new Meeting(0, 1), new Meeting(3, 5) , new Meeting (4, 8), new Meeting (10, 12), new Meeting(9,10)};
        //Meeting[] arr = {new Meeting(1, 5), new Meeting(2, 3)};

        System.out.println(condenseMeetingTimes(arr));

    }

    private static Stack<Meeting> condenseMeetingTimes(Meeting[] arr) {
        Arrays.sort(arr, (Meeting a, Meeting b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        Stack<Meeting> result = new Stack();
        result.push(arr[0]);
        for (Meeting m : arr) {
            Meeting lastResult = result.peek();
            if (m.start <= lastResult.end) {
                if (m.end > lastResult.end) {
                    result.pop();
                    result.push(new Meeting(lastResult.start, m.end));
                }
            } else {
                result.add(m);
            }
        }
        return result;
    }
}
