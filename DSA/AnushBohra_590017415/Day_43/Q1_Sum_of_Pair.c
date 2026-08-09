#include <stdio.h>
#include <stdlib.h>

// Comparator function for qsort to sort integers in ascending order
int compare(const void *a, const void *b) {
    int int_a = *(const int *)a;
    int int_b = *(const int *)b;
    
    if (int_a < int_b) return -1;
    if (int_a > int_b) return 1;
    return 0;
}

// Function to calculate the maximum sum of pair minimums
int arrayPairSum(int* nums, int numsSize) {
    // 1. Sort the array in non-decreasing order
    qsort(nums, numsSize, sizeof(int), compare);
    
    int sum = 0;
    
    // 2. Add elements at even indices (0, 2, 4, ...)
    for (int i = 0; i < numsSize; i += 2) {
        sum += nums[i];
    }
    
    return sum;
}

int main() {
    // Example 1
    int nums1[] = {1, 4, 3, 2};
    int size1 = sizeof(nums1) / sizeof(nums1[0]);
    int result1 = arrayPairSum(nums1, size1);
    printf("Example 1 Output: %d (Expected: 4)\n", result1);

    // Example 2
    int nums2[] = {6, 2, 6, 5, 1, 2};
    int size2 = sizeof(nums2) / sizeof(nums2[0]);
    int result2 = arrayPairSum(nums2, size2);
    printf("Example 2 Output: %d (Expected: 9)\n", result2);

    return 0;
}