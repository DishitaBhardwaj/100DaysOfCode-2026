#include <stdio.h>
int main() {
    int n;
    printf("Enter the size of array:");
    scanf("%d", &n);

    int arr[n];
    for (int i=0;i<n;i++){
        printf("Enter the element:");
        scanf("%d", &arr[i]);
    }
    int count=0;
    for (int i=0;i<n-1;i++){
        for (int j=i+1;j<n;j++){
            if (arr[i]>arr[j]){
                count++;
            }
        }
    }
    printf("%d\n", count);
    return 0;
}
