#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

bool canMakeArithmeticProgression(int* arr, int arrSize) {
    qsort(arr, arrSize, sizeof(int), compare);
    
    int diff = arr[1] - arr[0];
    
    for (int i = 2; i < arrSize; i++) {
        if (arr[i] - arr[i - 1] != diff) {
            return false;
        }
    }
    
    return true;
}

int main() {
    int test1[] = {3, 5, 1};
    int size1 = sizeof(test1) / sizeof(test1[0]);
    
    int test2[] = {1, 2, 4};
    int size2 = sizeof(test2) / sizeof(test2[0]);

    printf("Test 1 [3, 5, 1]: %s\n", canMakeArithmeticProgression(test1, size1) ? "true" : "false");
    printf("Test 2 [1, 2, 4]: %s\n", canMakeArithmeticProgression(test2, size2) ? "true" : "false");

    return 0;
}