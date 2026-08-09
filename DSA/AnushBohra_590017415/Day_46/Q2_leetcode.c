#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {

    bool seen[1001] = {false};
    
    for (int i = 0; i < nums1Size; i++) {
        seen[nums1[i]] = true;
    }
    
    // Allocate space for the maximum possible size of the result array
    int maxPossibleSize = nums1Size < nums2Size ? nums1Size : nums2Size;
    int* result = (int*)malloc(sizeof(int) * maxPossibleSize);
    
    int count = 0;
    for (int i = 0; i < nums2Size; i++) {
        int val = nums2[i];
        if (seen[val]) {
            result[count++] = val;
            seen[val] = false; 
        }
    }
    
    *returnSize = count;
    return result;
}

long long maximizePrefixDifference(const int arr[], int n) {
    if (n <= 1) {
        return 0;
    }

    int min_val = arr[0];
    int max_val = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] < min_val) {
            min_val = arr[i];
        }
        if (arr[i] > max_val) {
            max_val = arr[i];
        }
    }

    long long max_diff = (long long)max_val - min_val;
    long long max_score = (n - 1) * max_diff;

    return max_score;
}

int main(void) {
    printf("--- PART A: Intersection of Two Arrays ---\n");
    int nums1[] = {1, 2, 2, 1};
    int nums2[] = {2, 2};
    int returnSize = 0;

    int* res = intersection(nums1, 4, nums2, 2, &returnSize);

    printf("Intersection result: [");
    for (int i = 0; i < returnSize; i++) {
        printf("%d%s", res[i], (i == returnSize - 1) ? "" : ", ");
    }
    printf("]\n\n");

    free(res); 

    printf("--- PART B: Maximum Prefix Difference Score ---\n");
    int arr[] = {7, 6, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    long long score = maximizePrefixDifference(arr, n);
    printf("Maximum Prefix Difference Score: %lld\n", score);

    return 0;
}