class Solution {
    public int countInversions(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int[] temp = new int[arr.length];
        return mergeSortCount(arr, temp, 0, arr.length - 1);
    }

    private int mergeSortCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0; // base case: 0 or 1 element

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSortCount(arr, temp, left, mid);       // inversions in left half
        count += mergeSortCount(arr, temp, mid + 1, right);  // inversions in right half
        count += mergeAndCount(arr, temp, left, mid, right); // cross inversions

        return count;
    }

    private int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = left;      // pointer for temp array
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i..mid] are all greater than arr[j] (left half is sorted)
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        // copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // copy back into original array
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }

        return count;
    }
}
