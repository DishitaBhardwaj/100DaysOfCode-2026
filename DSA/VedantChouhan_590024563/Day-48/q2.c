#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    long long x = *(long long *)a;
    long long y = *(long long *)b;

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

    int size = n * (n - 1) / 2;

    long long b[size];

    printf("Enter the elements of b: ");

    for (int i = 0; i < size; i++) {
        scanf("%lld", &b[i]);
    }

    qsort(b, size, sizeof(long long), compare);

    long long a[n];

    int index = 0;

    for (int i = 0; i < n - 1; i++) {
        a[i] = b[index];
        index += (n - i - 1);
    }

    a[n - 1] = 1000000000LL;

    printf("One valid array a:\n");

    for (int i = 0; i < n; i++) {
        printf("%lld ", a[i]);
    }

    printf("\n");

    return 0;
}