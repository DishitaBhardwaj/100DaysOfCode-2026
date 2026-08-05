#include <stdio.h>

int main() {
    int n, m, k;

    scanf("%d", &n);
    int A[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

    scanf("%d", &m);
    int B[m];

    for (int i = 0; i < m; i++)
        scanf("%d", &B[i]);

    scanf("%d", &k);

    int C[n + m];
    int i = 0, j = 0, idx = 0;

    while (i < n && j < m) {
        if (A[i] < B[j])
            C[idx++] = A[i++];
        else
            C[idx++] = B[j++];
    }

    while (i < n)
        C[idx++] = A[i++];

    while (j < m)
        C[idx++] = B[j++];

    printf("%d\n", C[k - 1]);

    return 0;
}
