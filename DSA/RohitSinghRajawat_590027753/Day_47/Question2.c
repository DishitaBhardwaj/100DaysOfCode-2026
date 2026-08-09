#include <stdio.h>

int kthSmallest(int A[], int n, int B[], int m, int k)
{
    int i = 0, j = 0, count = 0;

    while (i < n && j < m)
    {
        if (A[i] < B[j])
        {
            count++;
            if (count == k)
                return A[i];
            i++;
        }
        else
        {
            count++;
            if (count == k)
                return B[j];
            j++;
        }
    }

    while (i < n)
    {
        count++;
        if (count == k)
            return A[i];
        i++;
    }

    while (j < m)
    {
        count++;
        if (count == k)
            return B[j];
        j++;
    }

    return -1;
}

int main()
{
    int A[] = {2, 3, 6, 7};
    int B[] = {1, 4, 5, 8};

    printf("%d\n", kthSmallest(A, 4, B, 4, 5));

    return 0;
}