#include <stdio.h>

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}

// Helper function to print an array
void printArray(const char* label, int* arr, int size) {
    printf("%s", label);
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("%d%s", arr[i], (i == size - 1) ? "" : ", ");
    }
    printf("]\n");
}

int main() {
    // Test Case 1
    int nums1[6] = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int nums2[3] = {2, 5, 6};
    int n = 3;

    printf("--- Test Case 1 ---\n");
    printArray("nums1 before: ", nums1, m + n);
    printArray("nums2:        ", nums2, n);

    merge(nums1, 6, m, nums2, 3, n);

    printArray("nums1 after:  ", nums1, m + n);

    // Test Case 2: Edge case where nums2 is empty
    int nums1_2[1] = {1};
    int m2 = 1;
    int nums2_2[0] = {};
    int n2 = 0;

    printf("\n--- Test Case 2 ---\n");
    merge(nums1_2, 1, m2, nums2_2, 0, n2);
    printArray("nums1 after:  ", nums1_2, m2 + n2);

    return 0;
}