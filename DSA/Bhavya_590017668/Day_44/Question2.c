#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b) {
    return (*(int *)b - *(int *)a);
}

void favouriteNumber(int arr[], int n, int f, int k) {
    int fav = arr[f - 1];

    qsort(arr, n, sizeof(int), cmp);

    int first = -1, last = -1;

    for (int i = 0; i < n; i++) {
        if (arr[i] == fav) {
            if (first == -1)
                first = i;
            last = i;
        }
    }

    if (last < k)
        printf("YES\n");
    else if (first >= k)
        printf("NO\n");
    else
        printf("MAYBE\n");
}