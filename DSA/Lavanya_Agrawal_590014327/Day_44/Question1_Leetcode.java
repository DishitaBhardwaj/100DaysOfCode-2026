import java.util.*;

public class Question1_Leetcode {

    public static boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int difference = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean result = canMakeArithmeticProgression(arr);

        System.out.println(result);

        sc.close();
    }
}