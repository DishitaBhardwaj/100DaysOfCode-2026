#include <stdio.h>
#include <stdlib.h>
int cmp(const void *a, const void *b) 
{
    return (*(int *)a - *(int *)b);
}
int maxPrefixDifferenceScore(int arr[],int n) 
{
    qsort(arr,n,sizeof(int),cmp);
    int temp[n];
    int left=0,right=n-1;
    int k=0;
    while(left<=right) 
    {
        if (right>=left)
            temp[k++]=arr[right--];
        if (left<=right)
            temp[k++]=arr[left++];
    }
    int mx=temp[0],mn=temp[0];
    int score=0;
    for (int i = 0; i < n; i++) 
    {
        if(temp[i]>mx)mx=temp[i];
        if(temp[i]<mn)mn=temp[i];
        score+=(mx-mn);
    }
    return score;
}
int main() 
{
    int arr[]={7,6,5};
    int n=sizeof(arr)/sizeof(arr[0]);
    printf("%d\n", maxPrefixDifferenceScore(arr,n));
    return 0;
}