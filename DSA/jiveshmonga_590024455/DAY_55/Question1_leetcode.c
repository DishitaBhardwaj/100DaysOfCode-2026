#include <stdlib.h>
typedef struct 
{
    int value;
    int index;
} Pair;

int cmpValue(const void *a, const void *b) 
{
    Pair *x=(Pair *)a;
    Pair *y=(Pair *)b;
    if (y->value!=x->value)
        return y->value-x->value;
    return x->index-y->index;
}
int cmpIndex(const void *a,const void *b) 
{
    Pair *x = (Pair *)a;
    Pair *y = (Pair *)b;
    return x->index - y->index;
}
int* maxSubsequence(int* nums,int numsSize,int k,int* returnSize) {
    Pair arr[1000];
    for (int i=0;i<numsSize;i++) {
        arr[i].value=nums[i];
        arr[i].index=i;
    }
    qsort(arr, numsSize, sizeof(Pair), cmpValue);

    Pair chosen[1000];
    for (int i=0;i<k;i++)
        chosen[i]=arr[i];
    qsort(chosen,k,sizeof(Pair),cmpIndex);
    int *ans = (int *)malloc(k * sizeof(int));
    for (int i=0;i<k;i++)
        ans[i]=chosen[i].value;
    *returnSize=k;
    return ans;
}
