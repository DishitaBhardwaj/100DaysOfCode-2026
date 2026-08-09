#include <stdlib.h>

typedef struct {
    int value;
    int index;
} Pair;

int compare(const void *a, const void *b)
{
    Pair *x = (Pair *)a;
    Pair *y = (Pair *)b;
    return y->value - x->value;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* maxSubsequence(int* nums, int numsSize, int k, int* returnSize)
{
    Pair *arr = malloc(numsSize * sizeof(Pair));
    int *ans = malloc(k * sizeof(int));

    for(int i = 0; i < numsSize; i++)
    {
        arr[i].value = nums[i];
        arr[i].index = i;
    }

    qsort(arr, numsSize, sizeof(Pair), compare);

    int selected[1000] = {0};

    for(int i = 0; i < k; i++)
        selected[arr[i].index] = 1;

    int j = 0;

    for(int i = 0; i < numsSize; i++)
    {
        if(selected[i])
            ans[j++] = nums[i];
    }

    free(arr);

    *returnSize = k;
    return ans;
}