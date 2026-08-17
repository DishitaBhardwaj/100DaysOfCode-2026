#include <stdio.h>

int mostFrequentEven(int* nums, int numsSize) {
    // Static frequency array initialized to 0 across calls
    static int freq[100001];
    
    // Clear array for each function call
    for (int i = 0; i <= 100000; i++) {
        freq[i] = 0;
    }

    int maxFreq = 0;
    int ans = -1;

    for (int i = 0; i < numsSize; i++) {
        int val = nums[i];
        
        if (val % 2 == 0) {
            freq[val]++;
            
            if (freq[val] > maxFreq || (freq[val] == maxFreq && val < ans)) {
                maxFreq = freq[val];
                ans = val;
            }
        }
    }

    return ans;
}

int main() {
    // Test Case 1: [0, 1, 2, 2, 4, 4, 1] -> 2 and 4 both appear twice, pick smaller (2)
    int test1[] = {0, 1, 2, 2, 4, 4, 1};
    int size1 = sizeof(test1) / sizeof(test1[0]);
    printf("Test 1 Result: %d (Expected: 2)\n", mostFrequentEven(test1, size1));

    // Test Case 2: [4, 4, 4, 9, 2, 4] -> 4 is most frequent
    int test2[] = {4, 4, 4, 9, 2, 4};
    int size2 = sizeof(test2) / sizeof(test2[0]);
    printf("Test 2 Result: %d (Expected: 4)\n", mostFrequentEven(test2, size2));

    // Test Case 3: [29, 47, 21, 41] -> No even elements
    int test3[] = {29, 47, 21, 41};
    int size3 = sizeof(test3) / sizeof(test3[0]);
    printf("Test 3 Result: %d (Expected: -1)\n", mostFrequentEven(test3, size3));

    return 0;
}