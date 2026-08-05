#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char vendor[21];
    char lot[21];
    char cert[21];
    int index;
} Delivery;

int compare(const void *a, const void *b) {
    Delivery *x = (Delivery *)a;
    Delivery *y = (Delivery *)b;

    int c = strcmp(x->vendor, y->vendor);
    if (c != 0)
        return c;

    return strcmp(x->lot, y->lot);
}

int main() {
    int n;
    scanf("%d", &n);

    Delivery d[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %s %s", d[i].vendor, d[i].lot, d[i].cert);
        d[i].index = i;
    }

    qsort(d, n, sizeof(Delivery), compare);

    int ans = -1;

    for (int i = 1; i < n; i++) {
        if (strcmp(d[i].vendor, d[i - 1].vendor) == 0 &&
            strcmp(d[i].lot, d[i - 1].lot) == 0 &&
            strcmp(d[i].cert, d[i - 1].cert) != 0) {

            int invalidIndex = (d[i].index > d[i - 1].index)
                                 ? d[i].index
                                 : d[i - 1].index;

            if (ans == -1 || invalidIndex < ans)
                ans = invalidIndex;
        }
    }

    printf("%d\n", ans);

    return 0;
}
