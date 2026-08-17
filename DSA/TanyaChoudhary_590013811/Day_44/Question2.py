def favouriteNumber(nums, favoriteIndex, k):
    n = len(nums)
    fav = nums[favoriteIndex]
    
    count_greater = sum(1 for x in nums if x > fav)
    count_equal   = sum(1 for x in nums if x == fav)
    
    if count_greater >= k:
        return "NO"
    elif count_greater + count_equal <= k:
        return "YES"
    else:
        return "MAYBE"

print(favouriteNumber([4,2,1,3,5], 4, 3))
print(favouriteNumber([4,2,1,3,5], 0, 3))
print(favouriteNumber([4,2,1,3,5], 2, 3))