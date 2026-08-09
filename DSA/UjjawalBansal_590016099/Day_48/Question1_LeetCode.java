import java.util.Arrays;

public class Question1_LeetCode {
    // One Line solution
    public int[][] sortTheStudentsOneLine(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

    //Proper solution
    public int[][] sortTheStudents(int[][] score, int k) {
        int r = score.length;
        int c = score[0].length;
        int[][] temp = new int[r][2];

        for (int i = 0; i < r; i++) {
            temp[i][0] = i;
            temp[i][1] = score[i][k];
        }

        Arrays.sort(temp, (a, b) -> Integer.compare(b[1], a[1]));

        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            ans[i] = score[temp[i][0]];
        }

        return ans;
    }
}
