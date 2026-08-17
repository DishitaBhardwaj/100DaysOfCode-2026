/**
 * LeetCode 2545 - Sort the Students by Their Kth Score
 */

//Need to sort the rows based on the kth exam score

import java.util.Arrays;

class Solution {

    public int[][] sortTheStudents(int[][] score, int k) {

        // sort rows in descending order using kth column
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));

        return score;
    }
}