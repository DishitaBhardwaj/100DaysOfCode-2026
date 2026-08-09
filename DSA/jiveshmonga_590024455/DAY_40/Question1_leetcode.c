#include <stdlib.h>

typedef struct {
    int *arr;
    int size;
    int capacity;
} FrontMiddleBackQueue;

void ensureCapacity(FrontMiddleBackQueue *obj) 
{
    if (obj->size == obj->capacity)
    {
        obj->capacity*=2;
        obj->arr=(int *)realloc(obj->arr, obj->capacity*sizeof(int));
    }
}
FrontMiddleBackQueue* frontMiddleBackQueueCreate() 
{
    FrontMiddleBackQueue *obj=(FrontMiddleBackQueue *)malloc(sizeof(FrontMiddleBackQueue));
    obj->capacity=100;
    obj->size=0;
    obj->arr=(int *)malloc(obj->capacity * sizeof(int));
    return obj;
}
void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) 
{
    ensureCapacity(obj);
    for (int i=obj->size;i>0;i--)
        obj->arr[i]=obj->arr[i-1];
    obj->arr[0]=val;
    obj->size++;
}
void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) 
{
    ensureCapacity(obj);
    int mid = obj->size/2;
    for (int i=obj->size;i>mid;i--)
        obj->arr[i]=obj->arr[i-1];
    obj->arr[mid]=val;
    obj->size++;
}
void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    ensureCapacity(obj);
    obj->arr[obj->size++] = val;
}
int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) 
{
    if (obj->size==0)
        return -1;
    int val = obj->arr[0];
    for (int i=0;i<obj->size-1;i++)
        obj->arr[i]=obj->arr[i+1];
    obj->size--;
    return val;
}
int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if (obj->size==0)
        return -1;
    int mid=(obj->size-1)/2;
    int val = obj->arr[mid];
    for (int i=mid;i<obj->size-1;i++)
        obj->arr[i]=obj->arr[i+1];
    obj->size--;
    return val;
}
int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) 
{
    if (obj->size==0)
        return -1;

    return obj->arr[--obj->size];
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) 
{
    free(obj->arr);
    free(obj);
}