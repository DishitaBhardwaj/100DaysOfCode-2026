#include <stdio.h>
int main() {
    int n, k, multiplier;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);

    printf("Enter multiplier: ");
    scanf("%d", &multiplier);

    for (int op = 0; op < k; op++) {
        int minIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        nums[minIndex] *= multiplier;
    }

    printf("Final array: [");
    for (int i = 0; i < n; i++) {
        printf("%d", nums[i]);
        if (i < n - 1)
            printf(", ");
    }
    printf("]\n");
    return 0;
}