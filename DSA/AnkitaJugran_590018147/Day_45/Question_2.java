import java.util.Scanner;

public class CountInversions {

    public static long inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static long mergeSort(int[] arr, int low, int high) {

        long count = 0;

        if (low < high) {

            int mid = low + (high - low) / 2;

            count += mergeSort(arr, low, mid);

            count += mergeSort(arr, mid + 1, high);

            count += merge(arr, low, mid, high);
        }

        return count;
    }

    public static long merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {

                temp[k++] = arr[j++];

                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long inversions = inversionCount(arr);

        System.out.println("Total Inversions = " + inversions);

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}