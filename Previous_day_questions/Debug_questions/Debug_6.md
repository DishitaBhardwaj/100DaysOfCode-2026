<h2 align="center">Week 6 Day 42 (26/07/2026) — Weekly Debug 6</h2>

## 1. DRS Review Gone Wrong

It is the IPL Playoffs. Virat Kohli has just been given out caught behind in a tense run chase - certain that the ball missed the bat, he immediately signals for a DRS review. The third umpire's system receives the request, but chaos follows.

Some reviews are processed correctly. Others appear to vanish. After a few have been handled, the system suddenly claims there are no pending requests - even though Virat's review is still waiting.

Engineers discover the DRS software uses a Queue to manage review requests. The code compiles and appears to work for basic cases, but multiple logical bugs cause failures when the queue undergoes several enqueue and dequeue operations.

You are given a buggy implementation of a circular queue. Identify and fix all bugs so that the review system works correctly again.

This problem is commonly asked in interviews and helps build concepts like:
- Queue (FIFO) operations
- Circular buffer / modular indexing
- Front and rear pointer management
- Overflow and underflow handling

which are important for writing correct and reliable programs.

**Your task:** Identify and fix all bugs in the given code so that it produces the correct output.

### What the Code Must Do

- Follow FIFO (First In First Out) ordering.
- Correctly handle queue overflow and underflow.
- Properly reuse freed positions.
- Accurately display all pending reviews.
- Continue functioning correctly after multiple enqueue and dequeue operations.

### Constraints

- 1 <= SIZE <= 100
- Review IDs are positive integers.
- Queue must maintain FIFO order at all times.
- Correct the existing implementation - do not rewrite using another data structure.
- Multiple logical bugs exist.

### Examples

**Input:**
```
enqueue(101)
enqueue(102)
enqueue(103)
dequeue()
enqueue(104)
enqueue(105)
display()
```
**Output:**
```
Processed Review: 101
Pending Reviews: 102 103 104 105
```

### Buggy Code

```c
#include <stdio.h>
#define SIZE 5
int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID)
{
    if ((rear + 1) % SIZE == front)
    {
        printf("Queue Full\n");
        return;
    }
    if (front == -1)
        front = 0;
    rear = (rear + 2) % SIZE;
    queue[rear] = reviewID;
}

int dequeue()
{
    if (front == rear)
    {
        printf("Queue Empty\n");
        return -1;
    }
    int review = queue[front];
    if (front == rear)
    {
        front = 0;
        rear = 0;
    }
    else
        front = (front + 1) % SIZE;
    return review;
}

void display()
{
    if (front == -1)
    {
        printf("No pending reviews\n");
        return;
    }
    printf("Pending Reviews: ");
    int i = front;
    while (i != rear)
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
