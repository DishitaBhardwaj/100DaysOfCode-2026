#include <stdio.h>

void maxSlidingWindow(int nums[], int n, int k) {
    int dq[n];
    int front = 0, rear = -1;

    for (int i = 0; i < n; i++) {

        // Remove indices that are out of the current window
        while (front <= rear && dq[front] <= i - k)
            front++;

        // Remove smaller elements from the back
        while (front <= rear && nums[dq[rear]] <= nums[i])
            rear--;

        // Insert current index
        dq[++rear] = i;

        // Print maximum for each window
        if (i >= k - 1)
            printf("%d ", nums[dq[front]]);
    }
}

int main() {
    int n, k;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter window size: ");
    scanf("%d", &k);

    if (k <= 0 || k > n) {
        printf("Invalid window size\n");
        return 0;
    }

    printf("Maximum in each window: ");
    maxSlidingWindow(nums, n, k);

    return 0;
}
