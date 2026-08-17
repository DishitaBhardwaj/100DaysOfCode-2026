typedef struct
{
    int *arr;
    int front;
    int rear;
    int size;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k)
{
    MyCircularQueue* obj = (MyCircularQueue*)malloc(sizeof(MyCircularQueue));

    obj->arr = (int*)malloc(k * sizeof(int));
    obj->size = k;
    obj->front = -1;
    obj->rear = -1;

    return obj;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value)
{
    if((obj->rear + 1) % obj->size == obj->front)
        return false;

    if(obj->front == -1)
    {
        obj->front = 0;
        obj->rear = 0;
    }
    else
    {
        obj->rear = (obj->rear + 1) % obj->size;
    }

    obj->arr[obj->rear] = value;

    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj)
{
    if(obj->front == -1)
        return false;

    if(obj->front == obj->rear)
    {
        obj->front = -1;
        obj->rear = -1;
    }
    else
    {
        obj->front = (obj->front + 1) % obj->size;
    }

    return true;
}

int myCircularQueueFront(MyCircularQueue* obj)
{
    if(obj->front == -1)
        return -1;

    return obj->arr[obj->front];
}

int myCircularQueueRear(MyCircularQueue* obj)
{
    if(obj->rear == -1)
        return -1;

    return obj->arr[obj->rear];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj)
{
    return obj->front == -1;
}

bool myCircularQueueIsFull(MyCircularQueue* obj)
{
    return (obj->rear + 1) % obj->size == obj->front;
}

void myCircularQueueFree(MyCircularQueue* obj)
{
    free(obj->arr);
    free(obj);
}