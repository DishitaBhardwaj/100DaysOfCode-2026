class Solution {
    public int[][] sortTheStudents(int[][] a, int k) {
        java.util.Arrays.sort(a, (x, y) -> y[k] - x[k]);
        return a;
    }
}