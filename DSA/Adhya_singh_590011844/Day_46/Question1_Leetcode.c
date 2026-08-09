#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int* intersection(int nums1[], int n1,
                  int nums2[], int n2,
                  int* resultSize) {

    bool present1[1001] = {false};
    bool added[1001] = {false};

    int* result = (int*)malloc(1001 * sizeof(int));
    *resultSize = 0;

    for (int i = 0; i < n1; i++) {
        present1[nums1[i]] = true;
    }

    for (int i = 0; i < n2; i++) {
        if (present1[nums2[i]] && !added[nums2[i]]) {
            result[(*resultSize)++] = nums2[i];
            added[nums2[i]] = true;
        }
    }

    return result;
}

int main() {
    int n1, n2;

    printf("Enter size of first array: ");
    scanf("%d", &n1);

    int nums1[n1];

    printf("Enter first array elements:\n");
    for (int i = 0; i < n1; i++) {
        scanf("%d", &nums1[i]);
    }

    printf("Enter size of second array: ");
    scanf("%d", &n2);

    int nums2[n2];

    printf("Enter second array elements:\n");
    for (int i = 0; i < n2; i++) {
        scanf("%d", &nums2[i]);
    }

    int resultSize;

    int* result = intersection(nums1, n1, nums2, n2, &resultSize);

    printf("Intersection: ");

    for (int i = 0; i < resultSize; i++) {
        printf("%d ", result[i]);
    }

    printf("\n");

    free(result);

    return 0;
}