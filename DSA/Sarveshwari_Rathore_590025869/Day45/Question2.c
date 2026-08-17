#include <stdio.h>
#include <stdlib.h>
int  merge(int arr[],int temp[],int left,int mid,int right){
    int i=left;
    int j=mid+1;
    int k=left;
    int count = 0;
    while(i<=mid && j<=right){
        if(arr[i] <= arr[j]){
            temp[k++] =arr[i++];
        }else{
            temp[k++] =arr[j++];
            count += (mid-i+1);
        }
    }
    while(i<=mid){
        temp[k++] = arr[i++];
    }
    while(j<=right){
        temp[k++] = arr[j++];
    }
    for(i=left;i<=right;i++){
        arr[i]=temp[i];
    }
    return count;
}
int mergeSort(int arr[],int temp,int left,int right){
    int count =0;
    if(left < right){
        int mid = left  + (right - left) / 2;
        count += mergeSort(arr,temp,left,mid);
        count += mergeSort(arr,temp,mid+1,right);
        count += merge(arr,temp,left,mid,right);
    }
    return count;
}
int main(){
    int n;
    scanf("%d",&n);
    int arr[n];
    int temp[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int inversions = mergeSort(arr,temp,0,n-1);
    printf("%d",inversions);
}