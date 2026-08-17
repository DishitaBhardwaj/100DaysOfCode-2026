#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int *data;
    int front;
    int rear;
}Deque;

int* maxSlidingWindow(int* nums,int numsSize,int k,int* returnSize){
    if(numsSize==0||k==0){
        *returnSize=0;
        return NULL;
    }
    *returnSize=numsSize-k+1;
    int *ans=(int*)malloc(sizeof(int)*(*returnSize));
    Deque dq;
    dq.data=(int*)malloc(sizeof(int)*numsSize);
    dq.front=0;
    dq.rear=-1;
    int idx=0;
    for(int i=0;i<numsSize;i++){
        while(dq.front<=dq.rear&&dq.data[dq.front]<=i-k)
            dq.front++;
        while(dq.front<=dq.rear&&nums[dq.data[dq.rear]]<=nums[i])
            dq.rear--;
        dq.data[++dq.rear]=i;
        if(i>=k-1)
            ans[idx++]=nums[dq.data[dq.front]];
    }
    free(dq.data);
    return ans;
}