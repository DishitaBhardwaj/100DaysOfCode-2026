#include <stdio.h>

int smallest(int a[], int n, int b[], int m, int k) {
    if (n > m)
        return smallest(b, m, a, n, k);

    int low=(k-m>0)?(k-m):0;
    int high=(k<n)?k:n;

    while (low<=high){
        int cuta=(low+high)/2;
        int cutb=k-cuta;

        int lefta=(cuta==0)?-1000000:A[cuta-1];
        int leftb=(cutb==0)?-1000000:B[cutb-1];

        int righta=(cuta==n)?1000000:a[cuta];
        int rightb=(cutb==m)?1000000:b[cutb];

        if (lefta<=rightb&&leftb<=righta)
            return (lefta>leftb)?lefta:leftb;

        if (lefta>rightb)
            high=cuta-1;
        else
            low=cuta+1;
    }
    return -1;
}

int main() {
    int n, m, k;
    printf("Enter size of first array: ");
    scanf("%d", &n);
    int a[n];
    printf("Enter %d sorted elements:\n", n);
    for (int i=0;i<n;i++){
        printf("Enter the element:");
        scanf("%d", &a[i]);
    }
    printf("Enter size of second array: ");
    scanf("%d", &m);
    int b[m];
    printf("Enter %d sorted elements:\n", m);
    for (int i=0;i<m;i++){
        printf("Enter the element:");
        scanf("%d", &b[i]);
    }
    printf("Enter value of k: ");
    scanf("%d", &k);

    if (k<1||k>n+m){
        printf("Invalid value of k.\n");
    } else {
        printf("K-th smallest element = %d\n", smallest(a, n, b, m, k));
    }

    return 0;
}
