#include <stdio.h>
#define SIZE 5

int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID) {
    // Check if queue is full
    if ((rear + 1) % SIZE == front) { 
        printf("Queue Full\n"); 
        return; 
    }
    
    // If inserting the first element
    if (front == -1) front = 0;
    
    // Advance rear circularly by 1 position (Fixed bug)
    rear = (rear + 1) % SIZE;  
    queue[rear] = reviewID;
}

int dequeue() {
    // Check if queue is empty (Fixed bug)
    if (front == -1) {
        printf("Queue Empty\n"); 
        return -1;
    }
    
    int review = queue[front];
    
    // If there was only one element left, reset queue to empty (Fixed bug)
    if (front == rear) { 
        front = -1; 
        rear = -1; 
    } else {
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
    while (i != rear) {
        printf("%d ", queue[i]);
        i = (i + 1) % SIZE;
    }
    printf("%d ", queue[i]); // Print the final element at rear (Fixed bug)
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