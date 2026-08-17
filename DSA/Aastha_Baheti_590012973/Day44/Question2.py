def favouriteNumber(nums, favoriteIndex, k):
    fav = nums[favoriteIndex - 1]

    greater = 0
    greater_equal = 0

    for x in nums:
        if x > fav:
            greater += 1
        if x >= fav:
            greater_equal += 1

    if greater >= k:
        return "NO"
    elif greater_equal <= k:
        return "YES"
    else:
        return "MAYBE"


# Example
nums = [4, 3, 3, 2, 3]
favoriteIndex = 2
k = 2
print(favouriteNumber(nums, favoriteIndex, k))