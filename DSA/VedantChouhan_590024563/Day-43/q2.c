#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {

    int size;

    printf("Enter number of elements (even): ");
    scanf("%d", &size);

    int nums[size];

    printf("Enter the elements: ");
    for (int i = 0; i < size; i++)
        scanf("%d", &nums[i]);

    qsort(nums, size, sizeof(int), compare);

    int sum = 0;

    for (int i = 0; i < size; i += 2)
        sum += nums[i];

    printf("Maximum Sum of Pair Minimums: %d\n", sum);

    return 0;
}