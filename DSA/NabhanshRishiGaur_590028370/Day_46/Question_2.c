#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n;
    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    qsort(nums, n, sizeof(int), compare);

    int arr[n];

    arr[0] = nums[0];
    if (n > 1)
        arr[1] = nums[n - 1];

    int idx = 2;
    for (int i = 1; i < n - 1; i++)
        arr[idx++] = nums[i];

    int minPrefix = arr[0];
    int maxPrefix = arr[0];
    int score = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] < minPrefix)
            minPrefix = arr[i];

        if (arr[i] > maxPrefix)
            maxPrefix = arr[i];

        score += (maxPrefix - minPrefix);
    }

    printf("%d\n", score);

    return 0;
}
