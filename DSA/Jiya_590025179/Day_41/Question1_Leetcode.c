typedef struct{
    int q[10000];
    int f;
    int r;
    int size;
    int k;
}MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k){
    MyCircularQueue *a=malloc(sizeof(MyCircularQueue));
    a->f=0;
    a->r=-1;
    a->size=0;
    a->k=k;
    return a;
}

bool myCircularQueueEnQueue(MyCircularQueue* a,int value){
    if(a->size==a->k) return false;
    a->r=(a->r+1)%a->k;
    a->q[a->r]=value;
    a->size++;
    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* a){
    if(a->size==0) return false;
    a->f=(a->f+1)%a->k;
    a->size--;
    return true;
}

int myCircularQueueFront(MyCircularQueue* a){
    if(a->size==0) return -1;
    return a->q[a->f];
}

int myCircularQueueRear(MyCircularQueue* a){
    if(a->size==0) return -1;
    return a->q[a->r];
}

bool myCircularQueueIsEmpty(MyCircularQueue* a){
    return a->size==0;
}

bool myCircularQueueIsFull(MyCircularQueue* a){
    return a->size==a->k;
}

void myCircularQueueFree(MyCircularQueue* a){
    free(a);
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
