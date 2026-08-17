typedef struct {
    int *arr;
    int front;
    int back;
    int size;
    int capacity;
} FrontMiddleBackQueue;

FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue* obj = (FrontMiddleBackQueue*)malloc(sizeof(FrontMiddleBackQueue));
    obj->capacity = 2000;
    obj->arr = (int*)malloc(sizeof(int) * obj->capacity);
    obj->front = 0;
    obj->back = -1;
    obj->size = 0;
    return obj;
}

void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
    for (int i = obj->size; i > 0; i--)
        obj->arr[i] = obj->arr[i - 1];
    obj->arr[0] = val;
    obj->size++;
    obj->back++;
}

void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    int mid = obj->size / 2;
    for (int i = obj->size; i > mid; i--)
        obj->arr[i] = obj->arr[i - 1];
    obj->arr[mid] = val;
    obj->size++;
    obj->back++;
}

void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    obj->arr[obj->size++] = val;
    obj->back++;
}

int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;
    int val = obj->arr[0];
    for (int i = 0; i < obj->size - 1; i++)
        obj->arr[i] = obj->arr[i + 1];
    obj->size--;
    obj->back--;
    return val;
}

int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;
    int mid = (obj->size - 1) / 2;
    int val = obj->arr[mid];
    for (int i = mid; i < obj->size - 1; i++)
        obj->arr[i] = obj->arr[i + 1];
    obj->size--;
    obj->back--;
    return val;
}

int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;
    obj->back--;
    return obj->arr[--obj->size];
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) {
    free(obj->arr);
    free(obj);
}