#include <stdio.h>
#include <string.h>

const char* favoriteResult(int nums[], int n, int favoriteIndex, int k) {
    int favoriteValue = nums[favoriteIndex - 1];

    int greater = 0;
    int equalBefore = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] > favoriteValue) {
            greater++;
        }

        if (nums[i] == favoriteValue) {
            equalBefore++;
        }
    }

    if (greater >= k) {
        return "NO";
    }

    if (greater + equalBefore <= k) {
        return "YES";
    }

    return "MAYBE";
}

int main() {
    int n, favoriteIndex, k;

    printf("Enter array size: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter favorite index (1-based): ");
    scanf("%d", &favoriteIndex);

    printf("Enter number of elements to remove: ");
    scanf("%d", &k);

    printf("%s\n",
           favoriteResult(nums, n, favoriteIndex, k));

    return 0;
}