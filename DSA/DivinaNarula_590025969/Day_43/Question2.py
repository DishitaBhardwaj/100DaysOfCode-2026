# Maximize Sum of Pair Minimums

nums = list(map(int, input("Enter the numbers: ").split()))

nums.sort()

total = 0

for i in range(0, len(nums), 2):
    total += nums[i]

print("Maximum sum of pair minimums:", total)