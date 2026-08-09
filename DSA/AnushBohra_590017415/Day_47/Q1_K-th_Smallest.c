#include <stdio.h>
#include <limits.h>

// Helper macro for maximum
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))

int kthSmallest(const int* A, int m, const int* B, int n, int k) {
    // Ensure A is the smaller array to minimize the binary search range
    if (m > n) {
        return kthSmallest(B, n, A, m, k);
    }

    // Binary search range for how many elements to pick from A
    int low = MAX(0, k - n);
    int high = MIN(k, m);

    while (low <= high) {
        int cut1 = low + (high - low) / 2;
        int cut2 = k - cut1;

        // Elements around the cut in array A
        int l1 = (cut1 == 0) ? INT_MIN : A[cut1 - 1];
        int r1 = (cut1 == m) ? INT_MAX : A[cut1];

        // Elements around the cut in array B
        int l2 = (cut2 == 0) ? INT_MIN : B[cut2 - 1];
        int r2 = (cut2 == n) ? INT_MAX : B[cut2];

        // Valid partition found
        if (l1 <= r2 && l2 <= r1) {
            return MAX(l1, l2);
        } 
        // Need to take fewer elements from A
        else if (l1 > r2) {
            high = cut1 - 1;
        } 
        // Need to take more elements from A
        else {
            low = cut1 + 1;
        }
    }

    return -1; // Should not be reached if k is valid
}

int main(void) {
    int A[] = {2, 3, 6, 7};
    int B[] = {1, 4, 5, 8};
    int m = sizeof(A) / sizeof(A[0]);
    int n = sizeof(B) / sizeof(B[0]);
    int k = 5;

    int result = kthSmallest(A, m, B, n, k);
    printf("The %d-th smallest element is: %d\n", k, result); // Output: 5

    return 0;
}