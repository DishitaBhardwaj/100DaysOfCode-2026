#include <stdio.h>

int main() {
    int n;
    printf("Enter the size of the array:");
    scanf("%d", &n);

    int arr[n];
    for (int i=0;i<n;i++){
        printf("Enter the element:");  
        scanf("%d", &arr[i]);
    }
    for (int i=0;i<n-1;i++){
        for (int j=i+1;j<n;j++){
            if (arr[i]<arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }

    int maxVal=arr[0];
    int minVal=arr[0];
    int score=0;

    for (int i=0;i<n;i++){
        if (arr[i]>maxVal)
            maxVal=arr[i];
        if (arr[i]<minVal)
            minVal=arr[i];
        score+=(maxVal-minVal);
    }

    printf("%d\n", score);

    return 0;
}
