
//Write an efficient function to calculate the sum of all elements in an integer array.
#include <stdio.h>

int sum_arr(int arr[],int n){
    int sum=0;
    for(int i=0;i<n;i++){
        sum+=arr[i];
    }
    return sum;
}
int main(){
    int arr[]={3,8,2,9,1};
    int n=sizeof(arr)/sizeof(arr[0]);
    int sum=sum_arr(arr,n);
    printf("Sum of all elements in the array: %d\n",sum);
}