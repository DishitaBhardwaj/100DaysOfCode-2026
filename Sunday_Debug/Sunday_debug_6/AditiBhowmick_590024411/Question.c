#include <stdio.h>
#define SIZE 100

int queue[SIZE];
int front = -1, rear = -1;

int isFull() {
    return ((rear + 1) % SIZE == front);
}

int isEmpty() {
    return (front == -1);
}

void enqueue(int reviewID) {
    if (isFull()) {
        printf("Queue Overflow\n");
        return;
    }

    if (isEmpty()) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % SIZE;
    }

    queue[rear] = reviewID;
}

int dequeue() {
    if (isEmpty()) {
        printf("Queue Underflow\n");
        return -1;
    }

    int review = queue[front];

    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % SIZE;
    }
    return review;
}

void display() {
    if (isEmpty()) {
        printf("No pending reviews\n");
        return;
    }

    printf("Pending Reviews: ");

    int i = front;
    while (1) {
        printf("%d ", queue[i]);

        if (i == rear)
            break;
        i = (i + 1) % SIZE;
    }

    printf("\n");
}

int main() {
    // Initial review requests
    enqueue(101);
    enqueue(102);
    enqueue(103);
    enqueue(104);

    printf("Processed Review: %d\n", dequeue());
    enqueue(105);
    display();

    return 0;
}