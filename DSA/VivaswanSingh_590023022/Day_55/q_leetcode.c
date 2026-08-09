/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct
{
    int value;
    int index;
} Element;

int compare(const void *a, const void *b)
{
    Element *x = (Element *)a;
    Element *y = (Element *)b;

    return y->value - x->value;
}
int* maxSubsequence(int* nums, int numsSize, int k, int* returnSize)
{
    Element *arr = malloc(numsSize * sizeof(Element));

    for (int i = 0; i < numsSize; i++)
    {
        arr[i].value = nums[i];
        arr[i].index = i;
    }
    qsort(arr, numsSize, sizeof(Element), compare);

    int *selected = calloc(numsSize, sizeof(int));

    for (int i = 0; i < k; i++)
        selected[arr[i].index] = 1;

    int *result = malloc(k * sizeof(int));
    int j = 0;

    for (int i = 0; i < numsSize; i++)
    {
        if (selected[i])
            result[j++] = nums[i];
    }

    free(arr);
    free(selected);

    *returnSize = k;
    return result;
}