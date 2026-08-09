import java.util.Arrays;

public class Main {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Find the common difference
        int diff = arr[1] - arr[0];

        // Check if every consecutive pair has the same difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 1};
        int[] arr2 = {1, 2, 4};

        System.out.println(canMakeArithmeticProgression(arr1)); // true
        System.out.println(canMakeArithmeticProgression(arr2)); // false
    }
}