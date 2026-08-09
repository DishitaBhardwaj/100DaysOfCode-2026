#include <stdio.h>

int main() {

    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    int favoriteIndex, k;

    printf("Enter favorite index (1-based): ");
    scanf("%d", &favoriteIndex);

    printf("Enter k: ");
    scanf("%d", &k);

    int favorite = nums[favoriteIndex - 1];

    int greater = 0, equal = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] > favorite)
            greater++;
        else if (nums[i] == favorite)
            equal++;
    }

    if (greater >= k)
        printf("NO\n");
    else if (greater + equal <= k)
        printf("YES\n");
    else
        printf("MAYBE\n");

    return 0;
}