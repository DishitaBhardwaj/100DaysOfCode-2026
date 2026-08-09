#include <stdio.h>
#include <limits.h>
int kthSmallest(int A[], int n, int B[], int m, int k) {

    if (n>m)
        return kthSmallest(B,m,A,n,k);
    int low=(k>m)?k-m:0;
    int high=(k<n)?k:n;
    while (low <= high) 
    {
        int cutA=(low+high)/2;
        int cutB=k-cutA;
        int leftA=(cutA==0)?INT_MIN:A[cutA-1];
        int leftB=(cutB==0)?INT_MIN:B[cutB-1];
        int rightA=(cutA==n)?INT_MAX:A[cutA];
        int rightB=(cutB == m)?INT_MAX:B[cutB];
        if (leftA<=rightB&&leftB<=rightA)
            return (leftA > leftB) ? leftA : leftB;
        else if (leftA>rightB)
            high=cutA-1;
        else
            low=cutA+1;
    }
    return -1;
}
int main() 
{
    int A[]={2,3,6,7};
    int B[]={1,4,5,8};
    int n=sizeof(A)/sizeof(A[0]);
    int m=sizeof(B)/sizeof(B[0]);
    int k=5;
    printf("K-th Smallest Element=%d\n",kthSmallest(A,n,B,m,k));
    return 0;
}