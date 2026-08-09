#include <stdio.h>
int main() {
    
    int n,ans=0;
    printf("enter size: ");
    scanf("%d",&n);
    int arr[n];
    printf("enter elements:\n");
    for(int i=0;i<n;i++) scanf("%d",&arr[i]);
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++) if(i<j && arr[i]>arr[j]) ans++;
    }
    
    printf("OUTPUT: %d",ans);
    return 0;
}
