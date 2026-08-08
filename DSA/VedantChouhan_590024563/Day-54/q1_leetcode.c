#include <stdio.h>

int main() {

    int n;

    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the array elements: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    int freq[101] = {0};

    for (int i = 0; i < n; i++) {
        freq[nums[i]]++;
    }

    int maxFreq = 0;

    for (int i = 1; i <= 100; i++) {
        if (freq[i] > maxFreq) {
            maxFreq = freq[i];
        }
    }

    int total = 0;

    for (int i = 1; i <= 100; i++) {
        if (freq[i] == maxFreq) {
            total += freq[i];
        }
    }

    printf("Total frequencies of elements with maximum frequency: %d\n", total);

    return 0;
}