nums = list(map(int, input("Enter the array elements: ").split()))
favoriteIndex = int(input("Enter favorite index (1-based): "))
k = int(input("Enter k: "))

favorite = nums[favoriteIndex - 1]

sorted_nums = sorted(nums, reverse=True)

greater = sum(1 for x in sorted_nums if x > favorite)
equal = sum(1 for x in sorted_nums if x == favorite)

if greater >= k:
    print("NO")          
elif greater + equal <= k:
    print("YES")         
else:
    print("MAYBE")       