


typedef struct {
    int q[10000];
    int front;
    int rear;
    int size;
    int k;
    
} MyCircularQueue;


MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue *obj=malloc(sizeof(MyCircularQueue));
    obj->front=0;
    obj->rear=-1;
    obj->size=0;
    obj->k=k;
    return obj;

}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if(obj->size==obj->k) return 0;
    obj->rear=(obj->rear+1)%obj->k;
    obj->q[obj->rear]=value;
    obj->size++;
    return 1;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if(obj->size==0) return 0;
    obj->front=(obj->front+1)%obj->k;
    obj->size--;
    return 1;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if(obj->size==0) return -1;
    return obj->q[obj->front];
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if(obj->size==0) return -1;
    return obj->q[obj->rear];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    return obj->size==0;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    return obj->size==obj->k;
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
