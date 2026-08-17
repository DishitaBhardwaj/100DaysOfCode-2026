#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int maximumPrefixDifferenceScore(int arr[], int n)
{
    qsort(arr, n, sizeof(int), compare);

    int *temp = (int *)malloc(n * sizeof(int));

    int left = 0, right = n - 1;
    int k = 0;

    while (left <= right)
    {
        temp[k++] = arr[right--];

        if (left <= right)
            temp[k++] = arr[left++];
    }

    int score = 0;
    int mx = temp[0], mn = temp[0];

    for (int i = 0; i < n; i++)
    {
        if (temp[i] > mx)
            mx = temp[i];

        if (temp[i] < mn)
            mn = temp[i];

        score += (mx - mn);
    }

    free(temp);

    return score;
}