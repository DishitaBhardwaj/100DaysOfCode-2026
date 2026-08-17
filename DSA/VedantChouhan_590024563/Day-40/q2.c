#include <stdio.h>

#define MAX 100000

void slidingWindowMaximum(int arr[], int n, int k) {

    int deque[MAX];
    int front = 0, rear = -1;

    printf("Maximums: ");

    for (int i = 0; i < n; i++) {

        // Remove indices outside the current window
        while (front <= rear && deque[front] <= i - k)
            front++;

        // Remove smaller elements from the back
        while (front <= rear && arr[deque[rear]] <= arr[i])
            rear--;

        // Add current index
        deque[++rear] = i;

        // Print maximum for current window
        if (i >= k - 1)
            printf("%d ", arr[deque[front]]);
    }

    printf("\n");
}

int main() {

    int n, k;

    printf("Enter number of temperatures: ");
    scanf("%d", &n);

    int temperatures[n];

    printf("Enter temperatures: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &temperatures[i]);

    printf("Enter window size: ");
    scanf("%d", &k);

    slidingWindowMaximum(temperatures, n, k);

    return 0;
}