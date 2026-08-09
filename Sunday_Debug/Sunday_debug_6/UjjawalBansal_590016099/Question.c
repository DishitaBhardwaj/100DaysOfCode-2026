#include <stdio.h>
#define SIZE 5

int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID) {
    if ((rear + 1) % SIZE == front) { printf("Queue Full\n"); return; }
    if (front == -1) front = 0;
    
    // Fix 1 -> Originally the enqueue operation moved two steps to write an ID "rear = (rear + 2) % SIZE". Corrected it to "rear = (rear + 1) % SIZE" 
    rear = (rear + 1) % SIZE;  
    queue[rear] = reviewID;
}

int dequeue() {
    // Fix 2 -> Wrong condition to check for an empty queue. Originally (front == rear) can still hold one element. Corrected it to (front = -1)
    if (front == -1) {
        printf("Queue Empty\n"); return -1;
    }
    int review = queue[front];
    // Fix 3 -> If the queue becomes empty, the front and rear pointers should point to -1, not to 0.
    if (front == rear) { front = -1; rear = -1; } 
    else front = (front + 1) % SIZE;
    return review;
}

void display() {
    if (front == -1) { printf("No pending reviews\n"); return; }
    printf("Pending Reviews: ");
    int i = front;
    // Bug 4 -> The loop "while (i != rear)" doesn't print the last element as the last element is in queue[rear].
    while (i != rear) {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    }

    // Fix 4 -> Print the last remaining element that the while loop stops before.
    printf("%d\n", queue[i]);
    printf("\n");
}

int main() {
    enqueue(101); enqueue(102); enqueue(103);
    printf("Processed Review: %d\n", dequeue());
    enqueue(104); enqueue(105);
    display();
    return 0;
}