#include <stdio.h>
#define SIZE 5

int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID) {
    if ((rear + 1) % SIZE == front) { 
        printf("Queue Full\n"); 
        return; 
    }
    if (front == -1) front = 0;
    
    // BUG 1 FIX: Was (rear + 2) % SIZE. Should increment by 1.
    rear = (rear + 1) % SIZE;  
    queue[rear] = reviewID;
}

int dequeue() {
    // BUG 2 FIX: Empty condition for circular queue is front == -1.
    if (front == -1) {
        printf("Queue Empty\n"); 
        return -1;
    }
    
    int review = queue[front];
    
    // BUG 3 FIX: When dequeueing the last element, reset front and rear to -1 (empty state).
    if (front == rear) { 
        front = -1; 
        rear = -1; 
    }
    else {
        front = (front + 1) % SIZE;
    }
    return review;
}

void display() {
    if (front == -1) { 
        printf("No pending reviews\n"); 
        return; 
    }
    
    printf("Pending Reviews: ");
    int i = front;
    
    // BUG 4 FIX: The loop condition (i != rear) skips the very last element. 
    // We need to iterate until we hit rear, and then print the rear element outside the loop.
    while (i != rear) {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    }
    // Print the final element at the rear index
    printf("%d\n", queue[rear]);
}

int main() {
    enqueue(101); enqueue(102); enqueue(103);
    printf("Processed Review: %d\n", dequeue());
    enqueue(104); enqueue(105);
    display();
    return 0;
}