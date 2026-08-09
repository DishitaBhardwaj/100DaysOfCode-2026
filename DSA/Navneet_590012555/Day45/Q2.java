class Solution {
    public int inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    int mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return 0;

        int mid = (l + r) / 2;

        int count = 0;
        count += mergeSort(arr, l, mid);
        count += mergeSort(arr, mid + 1, r);
        count += merge(arr, l, mid, r);

        return count;
    }

    int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = l, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];

        return count;
    }
}