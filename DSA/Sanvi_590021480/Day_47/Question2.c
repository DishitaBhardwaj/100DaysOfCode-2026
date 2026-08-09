#include <stdio.h>


int main() {
    
    int n,m,k;
    printf("Enter size of A: ");
    scanf("%d",&n);
    int A[n];
    printf("Enter elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&A[i]);
    }
    printf("Enter size of B: ");
    scanf("%d",&m);
    int B[m];
    printf("Enter elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&B[i]);
    }
    printf("Enter k: ");
    scanf("%d",&k);
    int i=0,j=0;
    int count=0,ans=0;
    while(count<k){
        if(i<n && j<n){
            if(A[i]<B[j]){
                ans=A[i];
                i++;
            }
            else{
                ans=B[j];
                j++;
            }
        }
        else if(i<n){
            ans=A[i];
            i++;
        }
        else{
            ans=B[j];
            j++;
        }
        count++;
    }
    printf("%d",ans);

    return 0;
}
