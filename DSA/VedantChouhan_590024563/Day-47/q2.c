#include <stdio.h>
#include <limits.h>

int kthSmallest(int A[], int n, int B[], int m, int k) {

    // Ensure A is the smaller array
    if (n > m)
        return kthSmallest(B, m, A, n, k);

    int low = (k > m) ? k - m : 0;
    int high = (k < n) ? k : n;

    while (low <= high) {

        int cutA = (low + high) / 2;
        int cutB = k - cutA;

        int Aleft = (cutA == 0) ? INT_MIN : A[cutA - 1];
        int Aright = (cutA == n) ? INT_MAX : A[cutA];

        int Bleft = (cutB == 0) ? INT_MIN : B[cutB - 1];
        int Bright = (cutB == m) ? INT_MAX : B[cutB];

        if (Aleft <= Bright && Bleft <= Aright) {
            return (Aleft > Bleft) ? Aleft : Bleft;
        }

        if (Aleft > Bright)
            high = cutA - 1;
        else
            low = cutA + 1;
    }

    return -1;
}

int main() {

    int n, m, k;

    printf("Enter size of first array: ");
    scanf("%d", &n);

    int A[n];

    printf("Enter elements of first array: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

    printf("Enter size of second array: ");
    scanf("%d", &m);

    int B[m];

    printf("Enter elements of second array: ");
    for (int i = 0; i < m; i++)
        scanf("%d", &B[i]);

    printf("Enter k: ");
    scanf("%d", &k);

    printf("K-th smallest element: %d\n", kthSmallest(A, n, B, m, k));

    return 0;
}