#include <stdio.h>
#include <stdlib.h>

int* window(int* nums, int numssize, int k, int* returnsize){
    if (numssize==0||k==0){
        *returnsize=0;
        return NULL;
    }
    int* result=(int*)malloc(sizeof(int)*(numssize-k+1));
    int* deque=(int*)malloc(sizeof(int)*numssize);
    int front=0, back=-1;
    int idx=0;
    for (int i=0;i<numssize;i++) {
        if (front<=back&&deque[front]<i-k+1){
            front++;
        }

        while (front<=back&&nums[deque[back]]<nums[i]){
            back--;
        }
        deque[++back]=i;
        if (i>=k-1){
            result[idx++]=nums[deque[front]];
        }
    }

    *returnSize=idx;
    return result;
}

int main() {
    int n,k;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int* arr=(int*)malloc(sizeof(int)*n);

    printf("Enter elements:\n");
    for (int i = 0; i < n; i++) {
        printf("Enter the element:");
        scanf("%d", &arr[i]);
    }

    printf("Enter window size k: ");
    scanf("%d", &k);
  
    int returnsize;

    int* result=window(arr, n, k, &returnSize);

    printf("Output:\n");
    for (int i=0;i<returnsize;i++){
        printf("%d ", result[i]);
    }
    free(arr);
    free(result);
    return 0;
}
