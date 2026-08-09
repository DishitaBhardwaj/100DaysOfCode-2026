def favourite_number(nums, favoriteIndex, k):
    # Favorite element (1-based index)
    fav = nums[favoriteIndex - 1]

    greater = 0
    equal = 0

    for num in nums:
        if num > fav:
            greater += 1
        elif num == fav:
            equal += 1

    if greater >= k:
        return "NO"
    elif greater + equal <= k:
        return "YES"
    else:
        return "MAYBE"


# Input
nums = list(map(int, input("Enter the numbers: ").split()))
favoriteIndex = int(input("Enter favorite index (1-based): "))
k = int(input("Enter k: "))

# Output
print(favourite_number(nums, favoriteIndex, k))