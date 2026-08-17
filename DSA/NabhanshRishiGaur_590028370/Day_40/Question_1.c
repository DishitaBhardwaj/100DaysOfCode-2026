#include <stdlib.h>

#define CAP 200000

typedef struct {
    int arr[CAP];
    int front, back, size;
} Deque;

void init(Deque* d) {
    d->front = CAP / 2;
    d->back = CAP / 2;
    d->size = 0;
}

void pushFrontD(Deque* d, int val) {
    d->arr[--d->front] = val;
    d->size++;
}

void pushBackD(Deque* d, int val) {
    d->arr[d->back++] = val;
    d->size++;
}

int popFrontD(Deque* d) {
    if (d->size == 0) return -1;
    int val = d->arr[d->front++];
    d->size--;
    return val;
}

int popBackD(Deque* d) {
    if (d->size == 0) return -1;
    int val = d->arr[--d->back];
    d->size--;
    return val;
}

typedef struct {
    Deque left, right;
} FrontMiddleBackQueue;

FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue* obj = malloc(sizeof(FrontMiddleBackQueue));
    init(&obj->left);
    init(&obj->right);
    return obj;
}

// balance invariant
void balance(FrontMiddleBackQueue* obj) {
    if (obj->left.size > obj->right.size + 1) {
        pushFrontD(&obj->right, popBackD(&obj->left));
    } else if (obj->left.size < obj->right.size) {
        pushBackD(&obj->left, popFrontD(&obj->right));
    }
}

// pushFront
void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
    pushFrontD(&obj->left, val);
    balance(obj);
}

// pushMiddle
void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    if (obj->left.size > obj->right.size) {
        pushFrontD(&obj->right, popBackD(&obj->left));
    }
    pushBackD(&obj->left, val);
}

// pushBack
void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    pushBackD(&obj->right, val);
    balance(obj);
}

// popFront
int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    int val;
    if (obj->left.size > 0) {
        val = popFrontD(&obj->left);
    } else {
        val = popFrontD(&obj->right);
    }
    balance(obj);
    return val;
}

// popMiddle
int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    int val = popBackD(&obj->left);
    balance(obj);
    return val;
}

// popBack
int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    int val;
    if (obj->right.size > 0) {
        val = popBackD(&obj->right);
    } else {
        val = popBackD(&obj->left);
    }
    balance(obj);
    return val;
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) {
    free(obj);
}
