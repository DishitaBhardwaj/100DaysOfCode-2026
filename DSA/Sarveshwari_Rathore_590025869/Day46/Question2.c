#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b){
    return (*(int *)a - *(int *)b);
}
int prefixDifferenceSum(int arr[], int n){
    int min = arr[0];
    int max = arr[0];
    int sum = 0;
    for(int i = 0; i < n; i++){
        if(arr[i] < min){
            min = arr[i];
        }
        if(arr[i] > max){
            max = arr[i];
        }
        sum += (max - min);
    }
    return sum;
}
int main(){
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++){
        scanf("%d",&arr[i]);
    }
    int ans[n];
    int left = 0;
    int right = n - 1;
    int k = 0;
    while(left <= right){
        if(left <= right){
            ans[k++] = arr[left++];
        }
        if(left <= right){
            ans[k++] = arr[right--];
        }
    }
    int result = prefixDifferenceSum(ans, n);
    printf("%d", result);
    return 0;
}