#include <stdio.h>
#include <stdlib.h>

const char* isFavoriteRemoved(int* nums, int numsSize, int favoriteIndex, int k) {
    // Convert 1-based index to 0-based index
    int favVal = nums[favoriteIndex - 1];
    
    int greater = 0;
    int equal = 0;
    
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > favVal) {
            greater++;
        } else if (nums[i] == favVal) {
            equal++;
        }
    }
    
    if (greater + equal <= k) {
        return "YES";    // Always removed
    } else if (greater >= k) {
        return "NO";     // Never removed
    } else {
        return "MAYBE";  // Depends on duplicate ordering
    }
}

int main() {
    int nums1[] = {4, 2, 1, 3, 5};
    int size1 = sizeof(nums1) / sizeof(nums1[0]);
    int favoriteIndex1 = 5; // Value at 1-based index 5 is 5
    int k1 = 3;
    
    printf("Result: %s\n", isFavoriteRemoved(nums1, size1, favoriteIndex1, k1));
    
    return 0;
}