<h2 align="center">Week 6 Day 42 (26/07/2026) — Weekly Debug 6</h2>

## 1. DRS Review Gone Wrong

### Solution

```c
#include <stdio.h>
#define SIZE 5
int queue[SIZE], front = -1, rear = -1, count = 0;

void enqueue(int reviewID)
{
    // BUG 1: overflow was checked using (rear + 1) % SIZE == front, which is unreliable
    // because that same condition can also be true for an empty queue, so a
    // separate count variable is needed to tell "full" and "empty" apart
    if (count == SIZE)
    {
        printf("Queue Full\n");
        return;
    }
    if (front == -1)
        front = 0;
    // BUG 2: rear was advanced by 2 instead of 1, silently skipping a slot on
    // every insert and corrupting the circular layout
    rear = (rear + 1) % SIZE;
    queue[rear] = reviewID;
    count++;
}

int dequeue()
{
    // BUG 3: underflow was checked using front == rear, but that condition is
    // also true when exactly ONE element remains, so a valid pending review
    // was wrongly reported as "Queue Empty"
    if (count == 0)
    {
        printf("Queue Empty\n");
        return -1;
    }
    int review = queue[front];
    // BUG 4: this reset block used the same front == rear check, which was
    // already consumed by the underflow check above, making it unreachable;
    // it should reset the queue only when removing the LAST remaining element
    if (count == 1)
    {
        front = -1;
        rear = -1;
    }
    else
        front = (front + 1) % SIZE;
    count--;
    return review;
}

void display()
{
    if (count == 0)
    {
        printf("No pending reviews\n");
        return;
    }
    printf("Pending Reviews: ");
    int i = front;
    // BUG 5: looping with while (i != rear) stopped before printing the
    // element sitting at rear, so the most recently enqueued review always
    // vanished from the display
    for (int c = 0; c < count; c++)
    {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    }
    printf("\n");
}

int main()
{
    enqueue(101);
    enqueue(102);
    enqueue(103);
    printf("Processed Review: %d\n", dequeue());
    enqueue(104);
    enqueue(105);
    display();
    return 0;
}
```
