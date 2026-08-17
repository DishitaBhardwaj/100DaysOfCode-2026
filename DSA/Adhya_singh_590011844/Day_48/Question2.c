#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    long long x = *(int *)a;
    long long y = *(int *)b;

    if (x < y)
        return -1;
    if (x > y)
        return 1;
    return 0;
}

int main() {
    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    int m = n * (n - 1) / 2;

    int *b = (int *)malloc(m * sizeof(int));
    int *a = (int *)malloc(n * sizeof(int));

    printf("Enter %d elements of b:\n", m);

    for (int i = 0; i < m; i++)
        scanf("%d", &b[i]);

    qsort(b, m, sizeof(int), compare);

    int index = 0;

    for (int i = 0; i < n - 1; i++) {
        a[i] = b[index];
        index += (n - i - 1);
    }

    a[n - 1] = b[m - 1];

    printf("One possible original array:\n");

    for (int i = 0; i < n; i++)
        printf("%d ", a[i]);

    printf("\n");

    free(a);
    free(b);

    return 0;
}