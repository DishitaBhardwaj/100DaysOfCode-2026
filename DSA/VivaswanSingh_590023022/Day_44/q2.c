char* isFavoriteRemoved(int* nums, int numsSize, int favoriteIndex, int k)
{
    int favorite = nums[favoriteIndex - 1];
    int greater = 0, equal = 0;

    for (int i = 0; i < numsSize; i++)
    {
        if (nums[i] > favorite)
            greater++;
        else if (nums[i] == favorite)
            equal++;
    }

    if (greater >= k)
        return "NO";

    if (greater + equal <= k)
        return "YES";

    return "MAYBE";
}