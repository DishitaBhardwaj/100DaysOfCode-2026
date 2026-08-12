#include <stdlib.h>

typedef struct {
    int value;
    int index;
} Pair;

int compareDescending(const void *a, const void *b) {
    Pair *p1 = (Pair *)a;
    Pair *p2 = (Pair *)b;

    return p2->value - p1->value;
}

int compareIndex(const void *a, const void *b) {
    Pair *p1 = (Pair *)a;
    Pair *p2 = (Pair *)b;

    return p1->index - p2->index;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* maxSubsequence(int* nums, int numsSize, int k, int* returnSize) {

    Pair *arr = malloc(numsSize * sizeof(Pair));

    // Store value and original index
    for (int i = 0; i < numsSize; i++) {
        arr[i].value = nums[i];
        arr[i].index = i;
    }

    // Sort by value in descending order
    qsort(arr, numsSize, sizeof(Pair), compareDescending);

    // Keep only k largest elements
    Pair *selected = malloc(k * sizeof(Pair));

    for (int i = 0; i < k; i++) {
        selected[i] = arr[i];
    }

    // Restore original order
    qsort(selected, k, sizeof(Pair), compareIndex);

    // Create answer
    int *answer = malloc(k * sizeof(int));

    for (int i = 0; i < k; i++) {
        answer[i] = selected[i].value;
    }

    *returnSize = k;

    free(arr);
    free(selected);

    return answer;
}
