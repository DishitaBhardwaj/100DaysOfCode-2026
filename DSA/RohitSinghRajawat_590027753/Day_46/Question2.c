#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int maxPrefixDifferenceSum(int arr[], int n)
{
    qsort(arr, n, sizeof(int), compare);

    int temp[n];
    int left = 0, right = n - 1;
    int k = 0;

    while(left <= right)
    {
        temp[k++] = arr[right--];

        if(left <= right)
            temp[k++] = arr[left++];
    }

    int runningMax = temp[0];
    int runningMin = temp[0];
    int sum = 0;

    for(int i = 0; i < n; i++)
    {
        if(temp[i] > runningMax)
            runningMax = temp[i];

        if(temp[i] < runningMin)
            runningMin = temp[i];

        sum += runningMax - runningMin;
    }

    return sum;
}

int main()
{
    int arr[] = {7, 6, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", maxPrefixDifferenceSum(arr, n));

    return 0;
}