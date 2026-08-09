#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

typedef struct {
    int *data;
    int head;
    int tail;
    int size;
    int capacity;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue* obj = (MyCircularQueue*)malloc(sizeof(MyCircularQueue));
    obj->data = (int*)malloc(k * sizeof(int));
    obj->head = -1;
    obj->tail = -1;
    obj->size = 0;
    obj->capacity = k;
    return obj;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if (obj->size == obj->capacity) return false;
    if (obj->head == -1) obj->head = 0;
    
    obj->tail = (obj->tail + 1) % obj->capacity;
    obj->data[obj->tail] = value;
    obj->size++;
    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if (obj->size == 0) return false;
    
    if (obj->head == obj->tail) {
        obj->head = -1;
        obj->tail = -1;
    } else {
        obj->head = (obj->head + 1) % obj->capacity;
    }
    
    obj->size--;
    return true;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if (obj->size == 0) return -1;
    return obj->data[obj->head];
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if (obj->size == 0) return -1;
    return obj->data[obj->tail];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    return obj->size == 0;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    return obj->size == obj->capacity;
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->data);
    free(obj);
}

int main() {
    MyCircularQueue* myCircularQueue = myCircularQueueCreate(3);
    printf("%s\n", myCircularQueueEnQueue(myCircularQueue, 1) ? "true" : "false"); // true
    printf("%s\n", myCircularQueueEnQueue(myCircularQueue, 2) ? "true" : "false"); // true
    printf("%s\n", myCircularQueueEnQueue(myCircularQueue, 3) ? "true" : "false"); // true
    printf("%s\n", myCircularQueueEnQueue(myCircularQueue, 4) ? "true" : "false"); // false
    printf("%d\n", myCircularQueueRear(myCircularQueue));                         // 3
    printf("%s\n", myCircularQueueIsFull(myCircularQueue) ? "true" : "false");     // true
    printf("%s\n", myCircularQueueDeQueue(myCircularQueue) ? "true" : "false");    // true
    printf("%s\n", myCircularQueueEnQueue(myCircularQueue, 4) ? "true" : "false"); // true
    printf("%d\n", myCircularQueueRear(myCircularQueue));                         // 4

    myCircularQueueFree(myCircularQueue);
    return 0;
}