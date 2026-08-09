// Problem 2 
// Favourite Number

#include <stdio.h>

void sort(int nums[], int n) {
    int temp;
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(nums[j] < nums[j + 1]) {
                temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
}

void favouriteNumber(int nums[], int n, int value, int k) {
    int greater = 0;
    int greaterOrEqual = 0;
    for(int i = 0; i < n; i++) {
        if(nums[i] > value) {
            greater++;
        }
        if(nums[i] >= value) {
            greaterOrEqual++;
        }
    }
    if(k <= greater) {
        printf("NO");
    }
    else if(k >= greaterOrEqual) {
        printf("YES");
    }
    else {
        printf("MAYBE");
    }
}

int main() {
    int n;
    printf("Enter size of array: ");
    scanf("%d", &n);
    int nums[n];

    printf("Enter elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    int favoriteIndex;
    int k;
    printf("Enter favorite index: ");
    scanf("%d", &favoriteIndex);
    printf("Enter k: ");
    scanf("%d", &k);

    int value = nums[favoriteIndex - 1];
    sort(nums, n);
    favouriteNumber(nums, n, value, k);

    return 0;
}