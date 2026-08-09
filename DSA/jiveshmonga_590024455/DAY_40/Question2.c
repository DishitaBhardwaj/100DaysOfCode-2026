#include <stdio.h>
#include <stdlib.h>

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) 
{
    *returnSize=numsSize-k+1;
    int *result=(int *)malloc((*returnSize) * sizeof(int));
    int *deque=(int *)malloc(numsSize * sizeof(int));
    int front=0,rear=-1;
    int idx=0;
    for (int i=0;i<numsSize;i++) {
        if (front<=rear&&deque[front]<=i-k)
            front++;
        while (front<=rear&&nums[deque[rear]]<=nums[i])
            rear--;
        deque[++rear]=i;
        if (i>=k-1)
            result[idx++]=nums[deque[front]];
    }
    free(deque);
    return result;
}
int main() 
{
    int temperatures[]={1,3,-1,-3,5,3,6,7};
    int n=sizeof(temperatures)/sizeof(temperatures[0]);
    int k=3;
    int returnSize;
    int *ans=maxSlidingWindow(temperatures,n,k,&returnSize);
    for (int i=0;i<returnSize;i++)
        printf("%d ",ans[i]);
    free(ans);
    return 0;
}