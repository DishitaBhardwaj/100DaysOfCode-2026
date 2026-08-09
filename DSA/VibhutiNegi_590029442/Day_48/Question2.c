#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}
int main() {
    int n;
    scanf("%d", &n);
    int size = n * (n - 1) / 2;
    int b[size];
    for (int i = 0; i < size; i++) {
        scanf("%d", &b[i]);
    }
    qsort(b, size, sizeof(int), compare);
    int a[n];
    int index = 0;
    for (int i = 0; i < n - 1; i++) {
        a[i] = b[index];
        index = index + (n - i - 1);
    }
    a[n - 1] = 1000000000;
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    return 0;
}