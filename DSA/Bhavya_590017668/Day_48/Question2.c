#include <stdlib.h>

int cmp(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int* reconstructArray(int *b, int n, int *returnSize) {
    int m = n * (n - 1) / 2;
    qsort(b, m, sizeof(int), cmp);

    int *a = (int *)malloc(n * sizeof(int));
    int idx = 0;

    for (int i = 0; i < n - 1; i++) {
        a[i] = b[idx];
        idx += (n - 1 - i);
    }

    a[n - 1] = 1000000000;

    *returnSize = n;
    return a;
}