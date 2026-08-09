#include <limits.h>

int min(int a, int b)
{
    return (a < b) ? a : b;
}

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int kthSmallest(int A[], int n, int B[], int m, int k)
{
    if (n > m)
        return kthSmallest(B, m, A, n, k);

    int low = max(0, k - m);
    int high = min(k, n);

    while (low <= high)
    {
        int cutA = (low + high) / 2;
        int cutB = k - cutA;

        int leftA = (cutA == 0) ? INT_MIN : A[cutA - 1];
        int rightA = (cutA == n) ? INT_MAX : A[cutA];

        int leftB = (cutB == 0) ? INT_MIN : B[cutB - 1];
        int rightB = (cutB == m) ? INT_MAX : B[cutB];

        if (leftA <= rightB && leftB <= rightA)
            return max(leftA, leftB);

        else if (leftA > rightB)
            high = cutA - 1;

        else
            low = cutA + 1;
    }

    return -1;
}