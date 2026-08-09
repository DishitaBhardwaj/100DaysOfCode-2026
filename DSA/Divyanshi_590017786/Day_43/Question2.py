def maximize_pair_sum(nums):
    nums.sort()

    total = 0
    for i in range(0, len(nums), 2):
        total += nums[i]

    return total


# Input
nums = list(map(int, input("Enter the numbers: ").split()))

# Output
print("Maximum Sum of Pair Minimums:", maximize_pair_sum(nums))