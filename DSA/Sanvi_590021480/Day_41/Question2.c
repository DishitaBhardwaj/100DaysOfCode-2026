#include <stdio.h>
#include <string.h>
#define max 1000

int main() {
    
    char q[max];
    printf("Enter string: ");
    scanf("%s",q);
    int sales[max],marketing[max];
    int front1=0,rear1=-1;
    int front2=0,rear2=-1;
    int n=strlen(q);
    for(int i=0;i<n;i++){
        if(q[i]=='S')
            sales[++rear1]=i;
        else
            marketing[++rear2]=i;
    }
    while(front1<=rear1 && front2<=rear2){
        int s=sales[front1++];
        int m=marketing[front2++];
        if(s<m)
            sales[++rear1]=s+n;
        else
            marketing[++rear2]=m+n;
    }
    if(front1<=rear1)
    printf("Sales");
    else
    printf("Marketing");
    
    return 0;
}
