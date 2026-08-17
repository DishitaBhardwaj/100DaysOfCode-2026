// Leetcode Problem 622
// Design Circular Queue

typedef struct {
    int arr[1000];
    int front;
    int rear;
} Queue;

typedef struct {
    Queue q;
    int count;
    int size;
} MyCircularQueue;

void enqueue(Queue *q, int value, int size) {
    q->rear++;
    if (q->rear == size)
        q->rear = 0;
    q->arr[q->rear] = value;
}

void dequeue(Queue *q, int size) {
    q->front++;
    if (q->front == size)
        q->front = 0;
}

MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue *obj = (MyCircularQueue *)malloc(sizeof(MyCircularQueue));
    obj->q.front = 0;
    obj->q.rear = -1;
    obj->count = 0;
    obj->size = k;
    return obj;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if (obj->count == obj->size)
        return false;
    enqueue(&obj->q, value, obj->size);
    obj->count++;
    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if (obj->count == 0)
        return false;
    dequeue(&obj->q, obj->size);
    obj->count--;
    return true;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if (obj->count == 0)
        return -1;
    return obj->q.arr[obj->q.front];
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if (obj->count == 0)
        return -1;
    return obj->q.arr[obj->q.rear];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    if (obj->count == 0)
        return true;
    return false;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    if (obj->count == obj->size)
        return true;
    return false;
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj);
}

/**
 * Your MyCircularQueue struct will be instantiated and called as such:
 * MyCircularQueue* obj = myCircularQueueCreate(k);
 * bool param_1 = myCircularQueueEnQueue(obj, value);
 
 * bool param_2 = myCircularQueueDeQueue(obj);
 
 * int param_3 = myCircularQueueFront(obj);
 
 * int param_4 = myCircularQueueRear(obj);
 
 * bool param_5 = myCircularQueueIsEmpty(obj);
 
 * bool param_6 = myCircularQueueIsFull(obj);
 
 * myCircularQueueFree(obj);
*/