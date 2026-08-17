package DSA.TanmaySharma_590011578.Day_48;
import java.util.Arrays;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }
}