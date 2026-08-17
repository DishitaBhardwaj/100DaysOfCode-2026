import java.util.*;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students (m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of exams (n): ");
        int n = sc.nextInt();

        int[][] score = new int[m][n];

        System.out.println("Enter the scores:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));

        System.out.println("Sorted Matrix:");
        for (int i = 0; i < m; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(score[i][j]);
                if (j != n - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }

        sc.close();
    }
}