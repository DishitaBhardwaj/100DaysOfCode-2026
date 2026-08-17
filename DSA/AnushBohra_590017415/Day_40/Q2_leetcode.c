#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node* prev;
    struct Node* next;
} Node;

typedef struct {
    Node* head;
    Node* tail;
    int size;
} FrontMiddleBackQueue;

Node* createNode(int val) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->val = val;
    node->prev = NULL;
    node->next = NULL;
    return node;
}

FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue* obj = (FrontMiddleBackQueue*)malloc(sizeof(FrontMiddleBackQueue));
    obj->head = NULL;
    obj->tail = NULL;
    obj->size = 0;
    return obj;
}

void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
    Node* node = createNode(val);
    if (obj->size == 0) {
        obj->head = obj->tail = node;
    } else {
        node->next = obj->head;
        obj->head->prev = node;
        obj->head = node;
    }
    obj->size++;
}

void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    Node* node = createNode(val);
    if (obj->size == 0) {
        obj->head = obj->tail = node;
    } else {
        node->prev = obj->tail;
        obj->tail->next = node;
        obj->tail = node;
    }
    obj->size++;
}

void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    if (obj->size == 0) {
        frontMiddleBackQueuePushFront(obj, val);
        return;
    }
    
    int midIndex = obj->size / 2;
    if (midIndex == 0) {
        frontMiddleBackQueuePushFront(obj, val);
        return;
    }

    Node* curr = obj->head;
    for (int i = 0; i < midIndex; i++) {
        curr = curr->next;
    }

    Node* node = createNode(val);
    node->prev = curr->prev;
    node->next = curr;
    curr->prev->next = node;
    curr->prev = node;

    obj->size++;
}

int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    if (obj->size == 0) return -1;

    Node* temp = obj->head;
    int val = temp->val;

    if (obj->size == 1) {
        obj->head = obj->tail = NULL;
    } else {
        obj->head = obj->head->next;
        obj->head->prev = NULL;
    }

    free(temp);
    obj->size--;
    return val;
}

int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    if (obj->size == 0) return -1;

    Node* temp = obj->tail;
    int val = temp->val;

    if (obj->size == 1) {
        obj->head = obj->tail = NULL;
    } else {
        obj->tail = obj->tail->prev;
        obj->tail->next = NULL;
    }

    free(temp);
    obj->size--;
    return val;
}

int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if (obj->size == 0) return -1;

    int midIndex = (obj->size - 1) / 2;
    Node* curr = obj->head;
    for (int i = 0; i < midIndex; i++) {
        curr = curr->next;
    }

    int val = curr->val;

    if (curr == obj->head) {
        return frontMiddleBackQueuePopFront(obj);
    } else if (curr == obj->tail) {
        return frontMiddleBackQueuePopBack(obj);
    } else {
        curr->prev->next = curr->next;
        curr->next->prev = curr->prev;
        free(curr);
        obj->size--;
    }

    return val;
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) {
    Node* curr = obj->head;
    while (curr) {
        Node* next = curr->next;
        free(curr);
        curr = next;
    }
    free(obj);
}

int main() {
    FrontMiddleBackQueue* q = frontMiddleBackQueueCreate();

    frontMiddleBackQueuePushFront(q, 1);   
    frontMiddleBackQueuePushBack(q, 2);    
    frontMiddleBackQueuePushMiddle(q, 3);  
    frontMiddleBackQueuePushMiddle(q, 4);  

    printf("popFront: %d\n", frontMiddleBackQueuePopFront(q));   
    printf("popMiddle: %d\n", frontMiddleBackQueuePopMiddle(q)); 
    printf("popMiddle: %d\n", frontMiddleBackQueuePopMiddle(q)); 
    printf("popBack: %d\n", frontMiddleBackQueuePopBack(q));     
    printf("popFront: %d\n", frontMiddleBackQueuePopFront(q));   

    frontMiddleBackQueueFree(q);
    return 0;
}