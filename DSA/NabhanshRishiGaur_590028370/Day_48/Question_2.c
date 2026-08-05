#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n;
    scanf("%d", &n);

    int m = n * (n - 1) / 2;
    int b[m];

    for (int i = 0; i < m; i++)
        scanf("%d", &b[i]);

    qsort(b, m, sizeof(int), compare);

    int ans[n];
    int pos = 0;
    int need = n - 1;

    for (int i = 0; i < m && pos < n - 1; ) {
        ans[pos++] = b[i];
        i += need;
        need--;
    }

    ans[n - 1] = 1000000000;

    for (int i = 0; i < n; i++)
        printf("%d ", ans[i]);

    return 0;
}
