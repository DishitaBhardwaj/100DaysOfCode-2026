#include <stdio.h>
void favoriteNumber(int nums[],int n,int favoriteIndex,int k) {
    int fav=nums[favoriteIndex-1];
    int greater=0,greaterEqual=0;
    for (int i=0;i<n;i++) 
    {
        if (nums[i]>fav)
            greater++;
        if (nums[i]>=fav)
            greaterEqual++;
    }
    if (greater>=k)
        printf("NO\n");
    else if (greaterEqual<=k)
        printf("YES\n");
    else
        printf("MAYBE\n");
}

int main() 
{
    int nums[] = {4,2,1,3,5};
    int n=sizeof(nums)/sizeof(nums[0]);
    int favoriteIndex=5;
    int k=3;
    favoriteNumber(nums,n,favoriteIndex,k);
    return 0;
}