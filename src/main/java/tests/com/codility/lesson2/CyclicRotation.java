package tests.com.codility.lesson2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ishishov on 6/19/16.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        List<Integer> list = IntStream.of(A).boxed().collect(Collectors.toList());
        Collections.rotate(list, K);
        return list.stream().mapToInt(i->i).toArray();
        // Or check Collections.rotate implementation
    }
}