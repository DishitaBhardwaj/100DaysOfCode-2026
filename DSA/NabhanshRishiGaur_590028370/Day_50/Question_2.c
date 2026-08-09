#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n;
    scanf("%d", &n);

    int rocks[10005];

    for (int i = 0; i < n; i++)
        scanf("%d", &rocks[i]);

    while (n > 1) {
        qsort(rocks, n, sizeof(int), compare);

        int x = rocks[n - 1];
        int y = rocks[n - 2];

        if (x == y) {
            n -= 2;
        } else {

            rocks[n - 2] = x - y;
            n--;
        }
    }

    if (n == 0)
        printf("0\n");
    else
        printf("%d\n", rocks[0]);

    return 0;
}
