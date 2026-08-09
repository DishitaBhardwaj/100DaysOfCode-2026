typedef struct {
    int *arr;
    int front;
    int rear;
    int count;
    int capacity;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k)
{
    MyCircularQueue *obj = (MyCircularQueue *)malloc(sizeof(MyCircularQueue));

    obj->arr = (int *)malloc(k * sizeof(int));
    obj->capacity = k;
    obj->front = 0;
    obj->rear = -1;
    obj->count = 0;

    return obj;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value)
{
    if (obj->count == obj->capacity)
        return false;

    obj->rear = (obj->rear + 1) % obj->capacity;
    obj->arr[obj->rear] = value;
    obj->count++;

    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj)
{
    if (obj->count == 0)
        return false;

    obj->front = (obj->front + 1) % obj->capacity;
    obj->count--;

    return true;
}

int myCircularQueueFront(MyCircularQueue* obj)
{
    if (obj->count == 0)
        return -1;

    return obj->arr[obj->front];
}

int myCircularQueueRear(MyCircularQueue* obj)
{
    if (obj->count == 0)
        return -1;

    return obj->arr[obj->rear];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj)
{
    return obj->count == 0;
}

bool myCircularQueueIsFull(MyCircularQueue* obj)
{
    return obj->count == obj->capacity;
}

void myCircularQueueFree(MyCircularQueue* obj)
{
    free(obj->arr);
    free(obj);
}