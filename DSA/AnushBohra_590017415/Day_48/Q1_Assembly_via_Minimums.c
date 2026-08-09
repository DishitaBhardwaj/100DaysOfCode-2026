#include <stdio.h>
#include <stdlib.h>

// Comparison function for qsort
int compare(const void *a, const void *b) {
    long long arg1 = *(const long long *)a;
    long long arg2 = *(const long long *)b;
    if (arg1 < arg2) return -1;
    if (arg1 > arg2) return 1;
    return 0;
}

// Function to reconstruct array 'a' from array 'b'
void reconstructArray(long long n, long long b[], long long b_size, long long a[]) {
    // 1. Sort array b in non-decreasing order
    qsort(b, b_size, sizeof(long long), compare);

    // 2. Pick elements based on remaining pair counts
    long long idx = 0;
    for (int i = 0; i < n - 1; i++) {
        a[i] = b[idx];
        idx += (n - 1 - i); // Jump (n - 1 - i) elements forward
    }

    // 3. The last element can be equal to a[n-2] or up to 10^9
    a[n - 1] = 1000000000LL; // 10^9
}

int main() {
    // Example test case: n = 3, b = [4, 2, 2]
    long long n = 3;
    long long b[] = {4, 2, 2};
    long long b_size = n * (n - 1) / 2;

    long long a[3]; // Output array

    reconstructArray(n, b, b_size, a);

    // Print output array
    printf("Reconstructed array a: ");
    for (int i = 0; i < n; i++) {
        printf("%lld ", a[i]);
    }
    printf("\n");

    return 0;
}