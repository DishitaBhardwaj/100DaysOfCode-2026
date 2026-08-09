#include <stdio.h>
#include <stdlib.h>

void getFinalState(int nums[], int n, int k, int multiplier) {

    while (k--) {
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        nums[minIndex] *= multiplier;
    }
}

int main() {
    int n, k, multiplier;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int *nums = (int *)malloc(n * sizeof(int));

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);

    printf("Enter multiplier: ");
    scanf("%d", &multiplier);

    getFinalState(nums, n, k, multiplier);

    printf("Final array:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }

    printf("\n");

    free(nums);

    return 0;
}