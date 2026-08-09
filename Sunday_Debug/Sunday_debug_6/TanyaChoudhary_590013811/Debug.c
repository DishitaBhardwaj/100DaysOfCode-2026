#include <stdio.h>
#define SIZE 5

int queue[SIZE], front = -1, rear = -1, count = 0;

void enqueue(int reviewID) {
    if (count == SIZE) { printf("Queue Full\n"); return; }
    if (front == -1) front = 0;
    rear = (rear + 1) % SIZE;
    queue[rear] = reviewID;
    count++;
}

int dequeue() {
    if (count == 0) { printf("Queue Empty\n"); return -1; }
    int review = queue[front];
    front = (front + 1) % SIZE;
    count--;
    if (count == 0) { front = -1; rear = -1; }
    return review;
}

void display() {
    if (count == 0) { printf("No pending reviews\n"); return; }
    printf("Pending Reviews: ");
    int i = front;
    for (int c = 0; c < count; c++) {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    }
    printf("\n");
}

int main() {
    enqueue(101); enqueue(102); enqueue(103);
    printf("Processed Review: %d\n", dequeue());
    enqueue(104); enqueue(105);
    display();
    return 0;
}