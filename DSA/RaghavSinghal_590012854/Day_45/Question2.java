public class CountInversions {

    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long inversions = 0;
        inversions += mergeSort(arr, left, mid);
        inversions += mergeSort(arr, mid + 1, right);
        inversions += merge(arr, left, mid, right);

        return inversions;
    }

    private static long merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        System.out.println("Number of inversions: " + countInversions(arr));
    }
}