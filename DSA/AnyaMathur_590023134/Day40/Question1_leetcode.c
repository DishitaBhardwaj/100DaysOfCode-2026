// Leetcode Problem 1670
// Design Front Middle Back Queue

#define MAX 1001
#define MID 500

typedef struct {
    int arr[MAX];
    int front;
    int rear;
    int size;
} Deque;

typedef struct {
    Deque left;
    Deque right;
} FrontMiddleBackQueue;

void initializeDeque(Deque *dq) {
    dq->front = MID;
    dq->rear = MID - 1;
    dq->size = 0;
}

void pushFrontDeque(Deque *dq, int val) {
    dq->arr[--dq->front] = val;
    dq->size++;
}

void pushBackDeque(Deque *dq, int val) {
    dq->arr[++dq->rear] = val;
    dq->size++;
}

int popFrontDeque(Deque *dq) {
    int val = dq->arr[dq->front];
    dq->front++;
    dq->size--;
    return val;
}

int popBackDeque(Deque *dq) {
    int val = dq->arr[dq->rear];
    dq->rear--;
    dq->size--;
    return val;
}

void balance(FrontMiddleBackQueue *obj) {
    if (obj->left.size > obj->right.size + 1) {
        int val = popBackDeque(&obj->left);
        pushFrontDeque(&obj->right, val);
    }
    else if (obj->left.size < obj->right.size) {
        int val = popFrontDeque(&obj->right);
        pushBackDeque(&obj->left, val);
    }
}

FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue *obj = (FrontMiddleBackQueue *)malloc(sizeof(FrontMiddleBackQueue));
    initializeDeque(&obj->left);
    initializeDeque(&obj->right);
    return obj;
}

void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
    pushFrontDeque(&obj->left, val);
    balance(obj);
}

void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    if (obj->left.size > obj->right.size) {
        int temp = popBackDeque(&obj->left);
        pushFrontDeque(&obj->right, temp);
    }
    pushBackDeque(&obj->left, val);
}

void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    pushBackDeque(&obj->right, val);
    balance(obj);
}

int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    if (obj->left.size + obj->right.size == 0)
        return -1;
    int val;
    if (obj->left.size > 0)
        val = popFrontDeque(&obj->left);
    else
        val = popFrontDeque(&obj->right);
    balance(obj);
    return val;
}

int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if (obj->left.size + obj->right.size == 0)
        return -1;
    int val = popBackDeque(&obj->left);
    balance(obj);
    return val;
}

int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    if (obj->left.size + obj->right.size == 0)
        return -1;
    int val;
    if (obj->right.size > 0)
        val = popBackDeque(&obj->right);
    else
        val = popBackDeque(&obj->left);
    balance(obj);
    return val;
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) {
    free(obj);
}

/**
 * Your FrontMiddleBackQueue struct will be instantiated and called as such:
 * FrontMiddleBackQueue* obj = frontMiddleBackQueueCreate();
 * frontMiddleBackQueuePushFront(obj, val);
 
 * frontMiddleBackQueuePushMiddle(obj, val);
 
 * frontMiddleBackQueuePushBack(obj, val);
 
 * int param_4 = frontMiddleBackQueuePopFront(obj);
 
 * int param_5 = frontMiddleBackQueuePopMiddle(obj);
 
 * int param_6 = frontMiddleBackQueuePopBack(obj);
 
 * frontMiddleBackQueueFree(obj);
*/