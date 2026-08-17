#include <stdio.h>

int main() {

    int numsSize, k, multiplier;

    printf("Enter the size of the array: ");
    scanf("%d", &numsSize);

    int nums[numsSize];

    printf("Enter the array elements: ");
    for (int i = 0; i < numsSize; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);

    printf("Enter multiplier: ");
    scanf("%d", &multiplier);

    for (int op = 0; op < k; op++) {

        int minIndex = 0;

        for (int i = 1; i < numsSize; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        nums[minIndex] *= multiplier;
    }

    printf("Final array: ");

    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }

    printf("\n");

    return 0;
}