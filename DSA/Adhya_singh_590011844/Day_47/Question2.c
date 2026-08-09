#include <stdio.h>
#include <limits.h>

int max(int a, int b) {
    return (a > b) ? a : b;
}

int min(int a, int b) {
    return (a < b) ? a : b;
}

int kthSmallest(int A[], int n, int B[], int m, int k) {
    if (n > m)
        return kthSmallest(B, m, A, n, k);

    int low = (k > m) ? (k - m) : 0;
    int high = (k < n) ? k : n;

    while (low <= high) {
        int cutA = (low + high) / 2;
        int cutB = k - cutA;

        int leftA = (cutA == 0) ? INT_MIN : A[cutA - 1];
        int leftB = (cutB == 0) ? INT_MIN : B[cutB - 1];

        int rightA = (cutA == n) ? INT_MAX : A[cutA];
        int rightB = (cutB == m) ? INT_MAX : B[cutB];

        if (leftA <= rightB && leftB <= rightA) {
            return max(leftA, leftB);
        }
        else if (leftA > rightB) {
            high = cutA - 1;
        }
        else {
            low = cutA + 1;
        }
    }

    return -1; 
}

int main() {
    int n, m, k;

    printf("Enter size of first array: ");
    scanf("%d", &n);

    int A[n];

    printf("Enter first sorted array:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

    printf("Enter size of second array: ");
    scanf("%d", &m);

    int B[m];

    printf("Enter second sorted array:\n");
    for (int i = 0; i < m; i++)
        scanf("%d", &B[i]);

    printf("Enter k: ");
    scanf("%d", &k);

    printf("K-th smallest element: %d\n", kthSmallest(A, n, B, m, k));

    return 0;
}