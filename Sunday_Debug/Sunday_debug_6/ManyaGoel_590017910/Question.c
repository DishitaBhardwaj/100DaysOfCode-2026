#include <stdio.h>
#define SIZE 100 // Maximum number of review requests the queue can hold at once (1 <= SIZE <= 100)

int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID) {
    if ((rear + 1) % SIZE == front) {
        printf("Queue Full\n"); 
        return; 
    }
    if (front == -1) {
        front = 0;
        rear = 0;  // FIX: Earlier only front was set (front = 0). We also need to set rear for the first insertion (rear=0).
    }else{
    rear = (rear + 1) % SIZE; // FIX: Rear should move one step at a time. (+2 skips positions) 
    }
    queue[rear] = reviewID;
}

int dequeue() {
    // FIX: An empty queue is identified by front == -1, not front == rear.
    if (front == -1) {
        printf("Queue Empty\n");
        return -1;
    }
    int review = queue[front];
    if (front == rear){
        // FIX: Earlier, front and rear were reset to 0. Reset both to -1 after removing the last element.
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
    // FIX: The old loop missed the last element, so print it after the loop.
    while (i != rear) {             
        printf("%d ", queue[i]);    
        i = (i + 1) % SIZE;
    }
    printf("%d ", queue[rear]); // Print the rear element as well.
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