nums = list(map(int, input("Enter the integers: ").split()))
nums.sort()

result = 0
for i in range(0, len(nums), 2):
    result += nums[i]

print("Maximum sum of pair minimums:", result)