#include <stdio.h>

#define SIZE 5

int queue[SIZE];
int front = -1, rear = -1;

int isFull() {
    return (rear + 1) % SIZE == front;
}

int isEmpty() {
    return front == -1;
}

void enqueue(int reviewID) {

    if (isFull()) {
        printf("Queue Full\n");
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
        printf("Queue Empty\n");
        return -1;
    }

    int x = queue[front];

    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % SIZE;
    }

    return x;
}

void display() {

    if (isEmpty()) {
        printf("No pending reviews\n");
        return;
    }

    printf("Pending Reviews: ");

    int i = front;

    do {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    } while (i != (rear + 1) % SIZE);

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
