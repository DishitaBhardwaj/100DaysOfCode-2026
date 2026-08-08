#include <stdio.h>

int maxFrequencyElements(int* nums, int numsSize) {
    int freq[101] = {0};
    int max_freq = 0;
    int total_elements = 0;

    for (int i = 0; i < numsSize; i++) {
        int val = nums[i];
        freq[val]++;

        if (freq[val] > max_freq) {
            max_freq = freq[val];
            total_elements = max_freq; // Reset for the new maximum frequency
        } else if (freq[val] == max_freq) {
            total_elements += max_freq; // Add to the total count for the current max frequency
        }
    }

    return total_elements;
}

int main() {
    // Test Case 1: [1, 2, 2, 3, 1, 4] -> frequencies: 1:2, 2:2, 3:1, 4:1. Max freq is 2, elements are 1 and 2 (total 4)
    int nums1[] = {1, 2, 2, 3, 1, 4};
    int size1 = sizeof(nums1) / sizeof(nums1[0]);
    printf("Test Case 1 Result: %d (Expected: 4)\n", maxFrequencyElements(nums1, size1));

    // Test Case 2: [1, 2, 3, 4, 5] -> all frequencies are 1. Max freq is 1, all elements count (total 5)
    int nums2[] = {1, 2, 3, 4, 5};
    int size2 = sizeof(nums2) / sizeof(nums2[0]);
    printf("Test Case 2 Result: %d (Expected: 5)\n", maxFrequencyElements(nums2, size2));

    return 0;
}