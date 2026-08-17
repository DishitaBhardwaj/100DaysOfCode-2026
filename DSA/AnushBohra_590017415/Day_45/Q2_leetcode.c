#include <stdio.h>

int searchInsert(int* nums, int numsSize, int target) {
    int left = 0;
    int right = numsSize - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return left;
}

int main() {
    int nums[] = {1, 3, 5, 6};
    int size = sizeof(nums) / sizeof(nums[0]);

    int target1 = 5;
    printf("Target %d -> Index: %d (Expected: 2)\n", target1, searchInsert(nums, size, target1));

    int target2 = 2;
    printf("Target %d -> Index: %d (Expected: 1)\n", target2, searchInsert(nums, size, target2));

    int target3 = 7;
    printf("Target %d -> Index: %d (Expected: 4)\n", target3, searchInsert(nums, size, target3));

    int target4 = 0;
    printf("Target %d -> Index: %d (Expected: 0)\n", target4, searchInsert(nums, size, target4));

    return 0;
}