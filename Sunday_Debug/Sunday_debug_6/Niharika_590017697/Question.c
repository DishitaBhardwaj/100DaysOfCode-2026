#include <stdio.h>

#define SIZE 5

int queue[SIZE];
int front = -1;
int rear = -1;

void enqueue(int reviewID) {
    // Check if queue is full
    if ((rear + 1) % SIZE == front) {
        printf("Queue Full\n");
        return;
    }

    // If queue is empty
    if (front == -1) {
        front = 0;
        rear = 0;
    } else {
        rear = (rear + 1) % SIZE;
    }

    queue[rear] = reviewID;
}

int dequeue() {
    // Check if queue is empty
    if (front == -1) {
        printf("Queue Empty\n");
        return -1;
    }

    int review = queue[front];

    // If only one element is present
    if (front == rear) {
        front = -1;
        rear = -1;
    } else {
        front = (front + 1) % SIZE;
    }

    return review;
}

void display() {
    // Check if queue is empty
    if (front == -1) {
        printf("No pending reviews\n");
        return;
    }

    printf("Pending Reviews: ");

    int i = front;

    while (1) {
        printf("%d ", queue[i]);

        if (i == rear) {
            break;
        }

        i = (i + 1) % SIZE;
    }

    printf("\n");
}

int main() {
    enqueue(101);
    enqueue(102);
    enqueue(103);

    printf("Processed Review: %d\n", dequeue());

    enqueue(104);
    enqueue(105);

    display();

    return 0;
}