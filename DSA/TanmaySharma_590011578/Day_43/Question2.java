package  DSA.TanmaySharma_590011578.Day_43;
import java.util.*;

public class Question2 {
    public static int maximizeSum(int[] arr) {
        Arrays.sort(arr);

        int sum = 0;

        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maximizeSum(arr));

        sc.close();
    }
}