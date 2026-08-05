#include <stdio.h>

void sortDescending(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] < arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    int favoriteIndex, k;
    scanf("%d %d", &favoriteIndex, &k);

    int favorite = nums[favoriteIndex - 1];

    sortDescending(nums, n);

    int first = -1, last = -1;

    for (int i = 0; i < n; i++) {
        if (nums[i] == favorite) {
            if (first == -1)
                first = i;
            last = i;
        }
    }

    if (k <= first)
        printf("NO\n");
    else if (k > last)
        printf("YES\n");
    else
        printf("MAYBE\n");

    return 0;
}
