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

    int maxFreq = 0;
    int answer = -1;

    for (int i = 0; i < n; i++) {

        if (nums[i] % 2 != 0) {
            continue;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == nums[i]) {
                count++;
            }
        }
        if (count > maxFreq) {
            maxFreq = count;
            answer = nums[i];
        }
        else if (count == maxFreq && nums[i] < answer) {
            answer = nums[i];
        }
    }

    printf("Most frequent even element: %d\n", answer);

    return 0;
}