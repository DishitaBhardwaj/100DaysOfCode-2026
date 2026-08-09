#include <stdio.h>
#include <stdlib.h>

int searchInsert(int nums[], int n, int target) {
    int left = 0;
    int right = n - 1;

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
    int n, target;

    printf("Enter array size: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter sorted array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter target: ");
    scanf("%d", &target);

    int index = searchInsert(nums, n, target);

    printf("Insert/Search Index: %d\n", index);

    return 0;
}