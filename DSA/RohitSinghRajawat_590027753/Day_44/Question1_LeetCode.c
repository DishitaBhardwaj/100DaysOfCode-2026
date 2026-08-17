#include <stdlib.h>
#include <stdbool.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

bool canMakeArithmeticProgression(int* arr, int arrSize)
{
    qsort(arr, arrSize, sizeof(int), compare);

    int diff = arr[1] - arr[0];

    for(int i = 1; i < arrSize - 1; i++)
    {
        if(arr[i + 1] - arr[i] != diff)
            return false;
    }

    return true;
}