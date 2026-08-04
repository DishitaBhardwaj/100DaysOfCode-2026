#include <stdio.h>
int main() {
    int n;
    printf("Enter the size of the array:");
    scanf("%d", &n);

    int rocks[n]; 
    for (int i=0;i<n;i++){
        printf("Enter the elements:");
        scanf("%d", &rocks[i]);
    }
    while (n>1){
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (rocks[i]<rocks[j]){
                    int temp=rocks[i];
                    rocks[i]=rocks[j];
                    rocks[j]=temp;
                }
            }
        }

        int y=rocks[0];
        int x=rocks[1];
        for (int i=2;i<n;i++){
            rocks[i-2]=rocks[i];
        }
        n-=2;
        if (y!=x){
            rocks[n]=y-x;
            n++;
        }
    }
    if (n==1)
        printf("%d\n", rocks[0]);
    else
        printf("0\n");
    return 0;
}
