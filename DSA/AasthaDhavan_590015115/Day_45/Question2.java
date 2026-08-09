import java.util.*;

public class Question2 {
    static int count = 0;

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);

        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) t[k++] = a[i++];
            else {
                t[k++] = a[j++];
                count += (m - i + 1);
            }
        }
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        System.arraycopy(t, 0, a, l, t.length);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(count);
    }
}