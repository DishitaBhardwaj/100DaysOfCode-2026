#include <stdio.h>

int main() {

    int n1, n2;

    printf("Enter size of first array: ");
    scanf("%d", &n1);

    int nums1[n1];

    printf("Enter elements of first array: ");
    for (int i = 0; i < n1; i++)
        scanf("%d", &nums1[i]);

    printf("Enter size of second array: ");
    scanf("%d", &n2);

    int nums2[n2];

    printf("Enter elements of second array: ");
    for (int i = 0; i < n2; i++)
        scanf("%d", &nums2[i]);

    int freq[1001] = {0};

    for (int i = 0; i < n1; i++)
        freq[nums1[i]] = 1;

    printf("Intersection: ");

    for (int i = 0; i < n2; i++) {
        if (freq[nums2[i]] == 1) {
            printf("%d ", nums2[i]);
            freq[nums2[i]] = 0;   // Prevent duplicates
        }
    }

    printf("\n");

    return 0;
}