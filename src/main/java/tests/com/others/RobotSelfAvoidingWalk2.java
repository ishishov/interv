package tests.com.others;

import java.util.*;

/**
 * Created by ishishov on 6/27/16.
 */
public class RobotSelfAvoidingWalk2 {
    static int m = 6;
    static int n = 4;
    static int end = m*n;

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i < m; i++) {
            for ( int j=0; j<m; j++) {
                int pos = position(i, j);
                map.put(pos, neighbours(i, j));
            }
        }

        System.out.println(count(map, new HashSet(), 1));
    }

    static int count(Map<Integer, List<Integer>> map, Set<Integer> visited, int position) {

        if (position == end) return 1;
        if (visited.contains(position)) return 0;

        Set<Integer> visitedNew = new HashSet<>(visited);
        visitedNew.add(position);

        int count = 0;
        for (Integer neighbour : map.get(position)) {
            count += count(map, visitedNew, neighbour);
        }

        return count;
    }

    private void printPath(LinkedList<String> visited) {
        for (String node : visited) {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
    }

    static int position(int i, int j) {
        return i*m + j + 1;
    }

    static List<Integer> neighbours(int i, int j) {
        List<Integer> neighbors = new ArrayList<>();
        if (j > 0) {
            Integer positionLeft = position(i, j-1);
            neighbors.add(positionLeft);
        }
        if (j < m-1) {
            Integer positionRight = position(i, j+1);
            neighbors.add(positionRight);
        }
        if (i>0) {
            Integer positionUp = position(i - 1, j);
            neighbors.add(positionUp);
        }
        if (i < m-1) {
            Integer positionDown = position(i + 1, j);
            neighbors.add(positionDown);
        }

        return neighbors;

    }

}
