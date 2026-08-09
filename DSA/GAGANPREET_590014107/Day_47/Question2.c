#include <stdio.h>

int kthSmallest(int A[], int m, int B[], int n, int k) {
    int i = 0, j = 0;
    int count = 0;
    int ans;

    while (i < m && j < n) {
        if (A[i] <= B[j]) {
            ans = A[i];
            i++;
        } else {
            ans = B[j];
            j++;
        }

        count++;
        if (count == k)
            return ans;
    }

    while (i < m) {
        ans = A[i];
        i++;
        count++;
        if (count == k)
            return ans;
    }

    while (j < n) {
        ans = B[j];
        j++;
        count++;
        if (count == k)
            return ans;
    }

    return -1; // Invalid k
}

int main() {
    int A[] = {2, 3, 6, 7};
    int B[] = {1, 4, 5, 8};
    int m = 4, n = 4;
    int k = 5;

    printf("%d\n", kthSmallest(A, m, B, n, k));

    return 0;
}
