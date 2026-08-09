#include <stdio.h>

#define MAX 100000

int mostFrequentEven(int nums[], int n) {
    int freq[MAX + 1] = {0};

    for (int i = 0; i < n; i++) {
        if (nums[i] % 2 == 0)
            freq[nums[i]]++;
    }

    int ans = -1;
    int maxFreq = 0;

    for (int i = 0; i <= MAX; i += 2) {
        if (freq[i] > maxFreq) {
            maxFreq = freq[i];
            ans = i;
        }
    }

    return ans;
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    int result = mostFrequentEven(nums, n);

    printf("Most Frequent Even Element: %d\n", result);

    return 0;
}