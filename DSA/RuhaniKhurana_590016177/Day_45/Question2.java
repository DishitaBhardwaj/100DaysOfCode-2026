class Solution {

    public long inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private long mergeSort(int[] a, int l, int r) {
        if (l >= r)
            return 0;

        int mid = l + (r - l) / 2;

        long inv = 0;
        inv += mergeSort(a, l, mid);
        inv += mergeSort(a, mid + 1, r);
        inv += merge(a, l, mid, r);

        return inv;
    }

    private long merge(int[] a, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        long inv = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                inv += (m - i + 1);
            }
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= r)
            temp[k++] = a[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            a[i] = temp[k];

        return inv;
    }
}