#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}
int arrayPairSum(int nums[], int numsSize)
{
    qsort(nums, numsSize, sizeof(int), compare);
    int sum = 0;
    for (int i = 0; i < numsSize; i += 2)
    {
        sum += nums[i];
    }
    return sum;
}
int main()
{
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int nums[n];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);
    printf("Maximum Sum = %d\n", arrayPairSum(nums, n));
    return 0;
}