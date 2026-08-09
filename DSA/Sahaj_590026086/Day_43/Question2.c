#include <stdio.h>
int main(){
    int n;
    printf("Enter the size of array:");
    scanf("%d", &n);

    int nums[n];
    for (int i=0;i<n;i++){
        printf("Enter the element:");
        scanf("%d", &nums[i]);
    }

    for (int i=0;i<n-1;i++){
        for (int j=i+1;j<n;j++){
            if (nums[i]>nums[j]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
    }

    int sum=0;
    for (int i=0;i<n;i+=2){
        sum += nums[i];
    }
    printf("%d\n", sum);
    return 0;
}
