package tests.com.cake;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ishishov on 5/14/16.
 */
public class MovieFlight_SumOf2 {

    public boolean getTwoMoviesToFillFlight(int[] movieLengths, int flightLength) {

        // movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<Integer>();

        for (int firstMovieLength : movieLengths) {

            int matchingSecondMovieLength = flightLength - firstMovieLength;
            if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
                return true;
            }

            movieLengthsSeen.add(firstMovieLength);
        }

        // we never found a match, so return false
        return false;
    }
}
