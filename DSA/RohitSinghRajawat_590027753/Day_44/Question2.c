#include <stdio.h>

int main()
{
    int nums[] = {4, 2, 1, 3, 5};
    int n = 5;
    int favoriteIndex = 5;
    int k = 3;

    int fav = nums[favoriteIndex - 1];

    int greater = 0;
    int equal = 0;

    for(int i = 0; i < n; i++)
    {
        if(nums[i] > fav)
            greater++;
        else if(nums[i] == fav)
            equal++;
    }

    if(greater >= k)
        printf("NO");
    else if(greater + equal <= k)
        printf("YES");
    else
        printf("MAYBE");

    return 0;
}