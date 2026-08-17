typedef struct{
    int front[10000], back[10000];
    int f1, r1, f2, r2;
} FrontMiddleBackQueue;

FrontMiddleBackQueue* frontMiddleBackQueueCreate(){
    FrontMiddleBackQueue* obj=(FrontMiddleBackQueue*)malloc(sizeof(FrontMiddleBackQueue));
    obj->f1=obj->r1=5000;
    obj->f2=obj->r2=5000;
    return obj;
}

void balance(FrontMiddleBackQueue* obj){
    if ((obj->r1-obj->f1)>(obj->r2-obj->f2)+1){
        obj->back[--obj->f2]=obj->front[--obj->r1];
    } else if ((obj->r1-obj->f1)<(obj->r2-obj->f2)){
        obj->front[obj->r1++]=obj->back[obj->f2++];
    }
}
void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val){
    obj->front[--obj->f1]=val;
    balance(obj);
}
void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val){
    if ((obj->r1-obj->f1)>(obj->r2-obj->f2)){
        obj->back[--obj->f2]=obj->front[--obj->r1];
    }
    obj->front[obj->r1++]=val;
}
void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val){
    obj->back[obj->r2++]=val;
    balance(obj);
}
int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj){
    if ((obj->r1-obj->f1)==0&&(obj->r2-obj->f2)==0) return -1;
    int val;
    if ((obj->r1-obj->f1)>0){
        val=obj->front[obj->f1++];
    }else{
        val=obj->back[obj->f2++];
    }
    balance(obj);
    return val;
}
int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj){
    if ((obj->r1-obj->f1)==0&&(obj->r2-obj->f2)==0) return -1;
    int val=obj->front[--obj->r1];
    balance(obj);
    return val;
}
int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj){
    if ((obj->r1-obj->f1)==0&&(obj->r2-obj->f2)==0) return -1;
    int val;
    if ((obj->r2-obj->f2)>0){
        val=obj->back[--obj->r2];
    }else{
        val=obj->front[--obj->r1];
    }
    balance(obj);
    return val;
}
void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj){
    free(obj);
}
