#include <stdio.h>
int main() {
    int n, k, index;
    printf("Enter the size of array:");
    scanf("%d", &n);
    int a[n];
    for (int i=0;i<n;i++){
        printf("Enter the number:");
        scanf("%d", &a[i]);
    }
    printf("Enter the value of favourite element:");
    scanf("%d", &index);
    printf("Enter the value of first k elements:");
    scanf("%d", &k);
    int value=a[index-1];
    for (int i=0;i<n-1;i++){
        for (int j=i+1;j<n;j++){
            if (a[i]<a[j]){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
    }
    int removed=0;
    for (int i=0;i<k;i++){
        if (a[i]==value){
            removed++;
        }
    }
    int same=0;
    for (int i=0;i<n;i++){
        if (a[i]==value){
            same++;
        }
    }
    if (removed==same){
        printf("YES\n");
    } else if (removed==0){
        printf("NO\n");
    } else {
        printf("MAYBE\n");
    }
    return 0;
}
