// Leetcode Problem 349
// Intersection of Two Arrays 

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdlib.h>
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int exists[1001] = {0};
    int added[1001] = {0};
    int *result = (int *)malloc(1001 * sizeof(int));
    int count = 0;
    for(int i = 0; i < nums1Size; i++) {
        exists[nums1[i]] = 1;
    }
    for(int i = 0; i < nums2Size; i++) {
        if(exists[nums2[i]] == 1 && added[nums2[i]] == 0) {
            result[count] = nums2[i];
            count++;
            added[nums2[i]] = 1;
        }
    }
    *returnSize = count;
    return result;
}