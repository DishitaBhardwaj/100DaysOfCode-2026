# Favourite Number

def favorite_number(nums, favorite_index, k):
    favorite = nums[favorite_index - 1]

    greater = 0
    equal = 0

    for num in nums:
        if num > favorite:
            greater += 1
        elif num == favorite:
            equal += 1

    if greater >= k:
        return "NO"
    elif greater + equal <= k:
        return "YES"
    else:
        return "MAYBE"


n = int(input("Enter number of elements: "))
nums = list(map(int, input("Enter elements: ").split()))
favorite_index, k = map(int, input("Enter favorite index and k: ").split())

print(favorite_number(nums, favorite_index, k))