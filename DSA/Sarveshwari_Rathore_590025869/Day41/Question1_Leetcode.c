typedef struct {
    int *arr;
    int front;
    int rear;
    int size;
    int capacity;
} MyCircularQueue;
MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue* obj = (MyCircularQueue*)malloc(sizeof(MyCircularQueue));
    obj->arr = (int*)malloc(k * sizeof(int));
    obj->capacity = k;
    obj->front = 0;
    obj->rear = -1;
    obj->size = 0;
    return obj;
}
bool enQueue(MyCircularQueue* obj, int value) {
    if (obj->size == obj->capacity)
        return false;
    obj->rear = (obj->rear + 1) % obj->capacity;
    obj->arr[obj->rear] = value;
    obj->size++;
    return true;
}
bool deQueue(MyCircularQueue* obj) {
    if (obj->size == 0)
        return false;
    obj->front = (obj->front + 1) % obj->capacity;
    obj->size--;
    return true;
}
int Front(MyCircularQueue* obj) {
    if (obj->size == 0)
        return -1;
    return obj->arr[obj->front];
}
int Rear(MyCircularQueue* obj) {
    if (obj->size == 0)
        return -1;
    return obj->arr[obj->rear];
}
bool isEmpty(MyCircularQueue* obj) {
    return obj->size == 0;
}
bool isFull(MyCircularQueue* obj) {
    return obj->size == obj->capacity;
}
void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->arr);
    free(obj);
}