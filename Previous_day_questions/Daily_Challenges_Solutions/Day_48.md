<h2 align="center">Week 7 Day 48 (01/08/2026)</h2>

## 1. Sort the Students by Their Kth Score (LeetCode #2545)

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

int k; // column index to sort by (global for the qsort comparator)

int compareRows(const void *a, const void *b) {
    const int *rowA = *(const int **)a;
    const int *rowB = *(const int **)b;
    return rowB[k] - rowA[k]; // descending order on column k
}

void sortTheStudents(int **score, int m, int n, int kk) {
    k = kk;
    qsort(score, m, sizeof(int *), compareRows);
}

static void printMatrix(int **mat, int m, int n) {
    printf("[");
    for (int i = 0; i < m; i++) {
        printf("[");
        for (int j = 0; j < n; j++) {
            printf("%d%s", mat[i][j], (j == n - 1) ? "" : ",");
        }
        printf("]%s", (i == m - 1) ? "" : ",");
    }
    printf("]\n");
}

int main(void) {
    // Sample 1
    int r0[] = {10, 6, 9, 1};
    int r1[] = {7, 5, 11, 2};
    int r2[] = {4, 8, 3, 15};
    int *mat1[] = {r0, r1, r2};
    sortTheStudents(mat1, 3, 4, 2);
    printMatrix(mat1, 3, 4); // [[7,5,11,2],[10,6,9,1],[4,8,3,15]]

    // Sample 2
    int s0[] = {3, 4};
    int s1[] = {5, 6};
    int *mat2[] = {s0, s1};
    sortTheStudents(mat2, 2, 2, 0);
    printMatrix(mat2, 2, 2); // [[5,6],[3,4]]

    return 0;
}
```

How it works: `qsort` is used directly on the array of row pointers (`int **score`), so no data is copied — only pointers get reordered. Since a plain `qsort` comparator can't take extra parameters, the column index `k` is kept in a file-scope variable that the comparator reads. Each comparison looks at `rowA[k]` vs `rowB[k]` and orders descending.

Complexity: O(m log m) time (m = number of students/rows), O(1) extra space beyond the sort itself — the matrix is reordered in place.

---

## 2. Assembly via Minimums

### Solution

Key insight: if the hidden array `a` is sorted **descending** as `a[0] ≥ a[1] ≥ ... ≥ a[n-1]`, then for any pair `i < j`, `min(a[i], a[j]) = a[j]`, since `a[j]` is the smaller (or equal) one. So each `a[j]` (for `j ≥ 1`) contributes exactly `j` copies to `b` — one for every earlier index it pairs with. That means:

* `a[1]` appears **1** time in `b` (it's the largest value in `b`)
* `a[2]` appears **2** times in `b`
* `a[3]` appears **3** times in `b`
* … and so on, up to `a[n-1]` appearing `n-1` times.

So the reconstruction is: sort `b` descending, repeatedly take the current largest remaining value as the next `a[j]`, and consume `j` copies of it. `a[0]` just needs to be at least as large as `a[1]`, so `a[1] + 1` works.

```c
#include <stdio.h>
#include <stdlib.h>

int cmpDesc(const void *a, const void *b) {
    long long x = *(const long long *)a;
    long long y = *(const long long *)b;
    if (x < y) return 1;
    if (x > y) return -1;
    return 0;
}

// Reconstructs array a of length n from array b of all pairwise minimums.
// b is sorted in place; caller must free the returned array.
long long* reconstructArray(long long *b, int bn, int n) {
    qsort(b, bn, sizeof(long long), cmpDesc);

    long long *a = malloc(n * sizeof(long long));
    int ptr = 0;
    for (int j = 1; j < n; j++) {
        a[j] = b[ptr];
        ptr += j;
    }
    a[0] = a[1] + 1; // any value >= a[1] works; +1 keeps it strictly the largest

    return a;
}

static void printArray(long long *arr, int n) {
    printf("[");
    for (int i = 0; i < n; i++) {
        printf("%lld%s", arr[i], (i == n - 1) ? "" : ", ");
    }
    printf("]\n");
}

int main(void) {
    // Sample 1
    long long b1[] = {5};
    long long *a1 = reconstructArray(b1, 1, 2);
    printArray(a1, 2); // [6, 5] — any array with min(a[0],a[1]) == 5 is valid

    // Sample 2
    long long b2[] = {4, 2, 2};
    long long *a2 = reconstructArray(b2, 3, 3);
    printArray(a2, 3); // [5, 4, 2]

    free(a1);
    free(a2);
    return 0;
}
```

Verification: recomputing all pairwise minimums of the reconstructed `[6, 5]` gives `{5}`, matching sample 1's `b`. Recomputing them for `[5, 4, 2]` gives `{min(5,4), min(5,2), min(4,2)} = {4, 2, 2}`, matching sample 2's `b` exactly (any array producing the same multiset is accepted per the problem statement).

Complexity: O(n² log n) time — dominated by sorting `b`, which has `n(n-1)/2` elements — and O(n²) extra space for `b` itself, both comfortably within the `n ≤ 1000` constraint.
