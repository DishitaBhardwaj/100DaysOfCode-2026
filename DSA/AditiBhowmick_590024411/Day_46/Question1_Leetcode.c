#include <stdio.h>
#include <stdbool.h>

int main() {
    int n1, n2;
    printf("Enter size of first array: ");
    scanf("%d", &n1);

    int nums1[n1];
    printf("Enter elements of first array:\n");
    for (int i = 0; i < n1; i++) {
        scanf("%d", &nums1[i]);
    }

    printf("Enter size of second array: ");
    scanf("%d", &n2);

    int nums2[n2];
    printf("Enter elements of second array:\n");
    for (int i = 0; i < n2; i++) {
        scanf("%d", &nums2[i]);
    }

    bool present[1001] = {false};
    bool added[1001] = {false};

    for (int i = 0; i < n1; i++) {
        present[nums1[i]] = true;
    }

    int result[1000];
    int size = 0;

    for (int i = 0; i < n2; i++) {
        if (present[nums2[i]] && !added[nums2[i]]) {
            result[size++] = nums2[i];
            added[nums2[i]] = true;
        }
    }

    printf("Intersection: [");
    for (int i = 0; i < size; i++) {
        printf("%d", result[i]);
        if (i < size - 1)
            printf(", ");
    }
    printf("]\n");
    return 0;
}