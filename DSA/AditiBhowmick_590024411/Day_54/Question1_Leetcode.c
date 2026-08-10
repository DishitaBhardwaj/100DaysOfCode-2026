#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);

    int nums[n];
    int freq[101] = {0};

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
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

    printf("%d\n", total);
    return 0;
}