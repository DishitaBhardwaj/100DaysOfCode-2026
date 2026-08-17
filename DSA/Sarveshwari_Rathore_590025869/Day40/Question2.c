#include <stdio.h>
#include <stdlib.h>

int main(){
    int n, k;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int nums[n];
    printf("Enter the elements:");
    for(int i = 0; i < n; i++){
        scanf("%d", &nums[i]);
    }
    printf("Enter window size: ");
    scanf("%d", &k);
    if(k <= 0 || k > n){
        printf("Invalid");
        return 0;
    }
    int deque[n];
    int top = 0, bottom = -1;
    for(int i = 0; i < n; i++){
        if(top <= bottom && deque[top] <= i - k){
            top++;
        }
        while(top <= bottom && nums[deque[bottom]] <= nums[i]){
            bottom--;
        }
        deque[++bottom] = i;
        if(i >= k - 1){
            printf("%d ", nums[deque[top]]);
        }
    }
    return 0;
}