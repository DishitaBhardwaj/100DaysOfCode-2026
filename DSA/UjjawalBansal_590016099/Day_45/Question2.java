import java.util.Scanner;

public class Question2 {

    public static long countInversionsInAnArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            invCount += mergeSortAndCount(arr, temp, left, mid);
            
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long swaps = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                swaps += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        long totalInversions = countInversionsInAnArray(arr);
        System.out.println("Total number of inversions: " + totalInversions);
        sc.close();
    }
}