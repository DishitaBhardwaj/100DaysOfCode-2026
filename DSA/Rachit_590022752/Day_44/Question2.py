nums = list(map(int, input("Enter array elements: ").split()))
favoriteIndex = int(input("Enter favorite index (1-based): "))
k = int(input("Enter k: "))

favorite = nums[favoriteIndex - 1]

greater = sum(1 for x in nums if x > favorite)
equal = sum(1 for x in nums if x == favorite)

if greater >= k:
    print("NO - Favorite element will not be removed.")
elif greater + equal <= k:
    print("YES - Favorite element will always be removed.")
else:
    print("MAYBE - Favorite element may or may not be removed.")
