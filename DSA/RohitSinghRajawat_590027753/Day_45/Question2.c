#include <stdio.h>

int countInversions(int arr[], int n)
{
    int count = 0;

    for(int i = 0; i < n; i++)
    {
        for(int j = i + 1; j < n; j++)
        {
            if(arr[i] > arr[j])
                count++;
        }
    }

    return count;
}

int main()
{
    int arr[] = {2, 4, 1, 3, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", countInversions(arr, n));

    return 0;
}