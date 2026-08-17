import java.util.*;

class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int difference = arr[1] - arr[0];
        boolean result = true;

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                result = false;
                break;
            }
        }

        System.out.println("Output: " + result);

        sc.close();
    }
}