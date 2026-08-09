// Problem 2 
// K-th Smallest Element in Two Sorted Arrays

#include <stdio.h>
#include <limits.h>

int kthElement(int A[], int n, int B[], int m, int k) {
    if (n > m)
        return kthElement(B, m, A, n, k);
    int low = 0;
    int high = n;
    while (low <= high) {
        int leftPartA = (low + high) / 2;
        int leftPartB = k - leftPartA;
        int leftA, rightA, leftB, rightB;

        if (leftPartA == 0)
            leftA = INT_MIN;
        else
            leftA = A[leftPartA - 1];

        if (leftPartA == n)
            rightA = INT_MAX;
        else
            rightA = A[leftPartA];

        if (leftPartB == 0)
            leftB = INT_MIN;
        else
            leftB = B[leftPartB - 1];

        if (leftPartB == m)
            rightB = INT_MAX;
        else
            rightB = B[leftPartB];

        if (leftA <= rightB && leftB <= rightA) {
            if (leftA > leftB)
                return leftA;
            else
                return leftB;
        }

        if (leftA > rightB)
            high = leftPartA - 1;
        else
            low = leftPartA + 1;
    }

    return -1;
}

int main() {
    int n, m, k;
    printf("Enter size of first array: ");
    scanf("%d", &n);

    int A[n];
    printf("Enter first sorted array: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

    printf("Enter size of second array: ");
    scanf("%d", &m);

    int B[m];
    printf("Enter second sorted array: ");
    for (int i = 0; i < m; i++)
        scanf("%d", &B[i]);

    printf("Enter k: ");
    scanf("%d", &k);

    printf("K-th smallest element = %d", kthElement(A, n, B, m, k));

    return 0;
}