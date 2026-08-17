


typedef struct {
    int q[100000];
    int front;
    int rear;
    
} FrontMiddleBackQueue;


FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue *obj=malloc(sizeof(FrontMiddleBackQueue));
    obj->front=0;
    obj->rear=-1;
    return obj;
}

void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
     for(int i=obj->rear;i>=obj->front;i--){
        obj->q[i+1]=obj->q[i];
     }
     obj->rear++;
     obj->q[obj->front]=val;
}

void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    int n=obj->rear-obj->front+1;
    int mid=obj->front+n/2;
    for(int i=obj->rear;i>=mid;i--){
        obj->q[i+1]=obj->q[i];
    }
    obj->q[mid]=val;
    obj->rear++;
}

void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    obj->q[++obj->rear]=val;
}

int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    if(obj->front>obj->rear) return -1;
    int first=obj->q[obj->front];
    for(int i=obj->front;i<obj->rear;i++){
        obj->q[i]=obj->q[i+1];
    }
    obj->rear--;
    return first;
}

int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if(obj->front>obj->rear) return -1;
    int n=obj->rear-obj->front+1;
    int mid=obj->front+(n-1)/2;
    int ans=obj->q[mid];
    for(int i=mid;i<obj->rear;i++){
        obj->q[i]=obj->q[i+1];
    }
    obj->rear--;
    return ans;
}

int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    if(obj->front>obj->rear) return -1;
    return obj->q[obj->rear--];
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
