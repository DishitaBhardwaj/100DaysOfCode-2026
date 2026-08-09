#include <stdio.h>
#include <stdlib.h>

int* initialDeck(int n) {
    int *deque = (int *)malloc(2 * n * sizeof(int));

    int front = n;
    int rear = n - 1;

    for (int card = n; card >= 1; card--) {

        if (front <= rear) {
            // Move last element to front
            deque[--front] = deque[rear];
            rear--;
        }

        // Insert current card at front
        deque[--front] = card;
    }

    int *ans = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        ans[i] = deque[front + i];

    free(deque);
    return ans;
}

int main() {
    int n;
    scanf("%d", &n);

    int *ans = initialDeck(n);

    printf("[");
    for (int i = 0; i < n; i++) {
        printf("%d", ans[i]);
        if (i != n - 1)
            printf(", ");
    }
    printf("]");

    free(ans);
    return 0;
}
