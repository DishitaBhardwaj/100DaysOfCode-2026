#include <stdio.h>

int maximumScore(int nums[], int n) {
    int min = nums[0];
    int max = nums[0];

    for (int i = 1; i < n; i++) {
        if (nums[i] < min)
            min = nums[i];
        if (nums[i] > max)
            max = nums[i];
    }

    return (n - 1) * (max - min);
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    int result = maximumScore(nums, n);

    printf("Maximum Score: %d\n", result);

    return 0;
}