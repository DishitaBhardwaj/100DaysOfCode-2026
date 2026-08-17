#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for(int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    int favoriteIndex, k;
    scanf("%d", &favoriteIndex);
    scanf("%d", &k);
    int favorite = nums[favoriteIndex - 1];
    int greater = 0, equal = 0;
    for(int i = 0; i < n; i++) {
        if(nums[i] > favorite)
            greater++;
        else if(nums[i] == favorite)
            equal++;
    }
    int first = greater + 1;
    int last = greater + equal;
    if(last <= k)
        printf("YES");
    else if(first > k)
        printf("NO");
    else
        printf("MAYBE");
    return 0;
}