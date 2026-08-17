#include <stdlib.h>

int* maxSlidingWindow(int* temperatures, int temperaturesSize, int k, int* returnSize)
{
    *returnSize = temperaturesSize - k + 1;
    int *result = (int *)malloc((*returnSize) * sizeof(int));

    int deque[100000];
    int front = 0, rear = -1;
    int index = 0;

    for (int i = 0; i < temperaturesSize; i++)
    {
        while (front <= rear && deque[front] <= i - k)
            front++;

        while (front <= rear &&
               temperatures[deque[rear]] <= temperatures[i])
            rear--;

        deque[++rear] = i;

        if (i >= k - 1)
            result[index++] = temperatures[deque[front]];
    }

    return result;
}