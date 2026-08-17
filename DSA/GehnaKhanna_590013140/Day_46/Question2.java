import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int maximumPrefixDifferenceScore(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;

        int[] b = new int[n];

        b[0] = arr[0];
        b[1] = arr[n - 1];

        int index = 2;

        for (int i = 1; i < n - 1; i++) {
            b[index++] = arr[i];
        }

        int min = b[0];
        int max = b[0];
        int score = 0;

        for (int x : b) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            score += (max - min);
        }

        return score;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maximumPrefixDifferenceScore(arr));

        sc.close();
    }
}
