#include <stdio.h>

int main() {

    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    int min = nums[0];
    int max = nums[0];

    for (int i = 1; i < n; i++) {
        if (nums[i] < min)
            min = nums[i];
        if (nums[i] > max)
            max = nums[i];
    }

    long long score = (long long)(n - 1) * (max - min);

    printf("Maximum Score: %lld\n", score);

    return 0;
}