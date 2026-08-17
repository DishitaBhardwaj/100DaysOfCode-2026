#include <stdio.h>

int min(int a, int b) {
    return a < b ? a : b;
}

int kthSmallest(int arr1[], int n1, int arr2[], int n2, int k) {
    int i = 0, j = 0;

    while (1) {
        if (i == n1)
            return arr2[j + k - 1];
        if (j == n2)
            return arr1[i + k - 1];
        if (k == 1)
            return arr1[i] < arr2[j] ? arr1[i] : arr2[j];

        int half = k / 2;
        int ni = min(i + half, n1) - 1;
        int nj = min(j + half, n2) - 1;

        if (arr1[ni] <= arr2[nj]) {
            k -= (ni - i + 1);
            i = ni + 1;
        } else {
            k -= (nj - j + 1);
            j = nj + 1;
        }
    }
}