import java.util.Arrays;

public class Main {

    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i != row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        int[][] score = {
            {10, 6, 9, 1},
            {7, 5, 11, 2},
            {4, 8, 3, 15}
        };

        int k = 2;

        int[][] result = sortTheStudents(score, k);

        System.out.println("Sorted Matrix:");
        printMatrix(result);
    }
}