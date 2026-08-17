// Problem 2
// Maximize Sum of Pair Minimums

#include <stdio.h>

int main() {
    int n;
    int i, j, temp;
    int sum = 0;
    printf("Enter the number of pairs: ");
    scanf("%d", &n);

    int nums[2 * n];
    printf("Enter %d elements: ", 2 * n);
    for (i = 0; i < 2 * n; i++) {
        scanf("%d", &nums[i]);
    }

    for (i = 0; i < 2 * n - 1; i++) {
        for (j = 0; j < 2 * n - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }

    for (i = 0; i < 2 * n; i = i + 2) {
        sum = sum + nums[i];
    }

    printf("Maximum possible sum of the minimum values of each pair = %d", sum);
    
    return 0;
}