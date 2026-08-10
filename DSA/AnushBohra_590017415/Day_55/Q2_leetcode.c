#include <stdio.h>
#include <stdlib.h>

// Structure to pair a value with its original index
typedef struct {
    int val;
    int index;
} Element;

// Comparator to sort elements in descending order of value
int compareVal(const void* a, const void* b) {
    Element* e1 = (Element*)a;
    Element* e2 = (Element*)b;
    return e2->val - e1->val;
}

// Comparator to sort elements in ascending order of original index
int compareIndex(const void* a, const void* b) {
    Element* e1 = (Element*)a;
    Element* e2 = (Element*)b;
    return e1->index - e2->index;
}

int* maxSubsequence(int* nums, int numsSize, int k, int* returnSize) {
    Element* arr = (Element*)malloc(numsSize * sizeof(Element));
    for (int i = 0; i < numsSize; i++) {
        arr[i].val = nums[i];
        arr[i].index = i;
    }

    // Sort by value descending to pick top k elements
    qsort(arr, numsSize, sizeof(Element), compareVal);

    // Sort top k elements by original index ascending to preserve relative order
    qsort(arr, k, sizeof(Element), compareIndex);

    int* result = (int*)malloc(k * sizeof(int));
    for (int i = 0; i < k; i++) {
        result[i] = arr[i].val;
    }

    free(arr);
    *returnSize = k;
    return result;
}

int main() {
    // Example test case: nums = [2, 1, 3, 3], k = 2
    int nums[] = {2, 1, 3, 3};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int k = 2;
    int returnSize = 0;

    int* result = maxSubsequence(nums, numsSize, k, &returnSize);

    printf("Input Array: ");
    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\nk = %d\n", k);

    printf("Max Subsequence: [");
    for (int i = 0; i < returnSize; i++) {
        printf("%d%s", result[i], (i == returnSize - 1) ? "" : ", ");
    }
    printf("]\n");

    free(result);
    return 0;
}