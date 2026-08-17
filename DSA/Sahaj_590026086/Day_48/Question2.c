#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Enter the size of array:");
    scanf("%d", &n);

    int size=n*(n-1)/2;
    int *b=(int *)malloc(size*sizeof(int));

    for (int i=0;i<size;i++){
        printf("Enter the elements:");
        scanf("%d", &b[i]);
    }
    int cmp(const void *a, const void *b) {
        return (*(int *)a-*(int *)b);
    }

    qsort(b, size, sizeof(int), cmp);

    int *a=(int *)malloc(n*sizeof(int));

    int idx=0;
    for (int i=0;i<n-1;i++){
        a[i]=b[idx];
        idx+=(n-i-1);
    }
    a[n-1]=1000000000;
    for (int i=0;i<n;i++){
        printf("%d ", a[i]);
    }
    free(b);
    free(a);
    return 0;
}
