#include <stdio.h>

int main()
{
    int n, k, favoriteIndex;

    scanf("%d", &n);

    int nums[n];

    for(int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    scanf("%d", &favoriteIndex);
    scanf("%d", &k);

  
    int favorite = nums[favoriteIndex - 1];

    int greater = 0;
    int equal = 0;

    for(int i = 0; i < n; i++)
    {
        if(nums[i] > favorite)
            greater++;

        if(nums[i] == favorite)
            equal++;
    }


    if(k <= greater)
    {
        printf("NO\n");   
    }
    else if(k >= greater + equal)
    {
        printf("YES\n");  
    }
    else
    {
        printf("YES\n");  
    }

    return 0;
}
