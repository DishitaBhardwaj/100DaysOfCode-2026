def getFinalState(nums, k, multiplier):
    for _ in range(k):
        min_index = 0

        for i in range(1, len(nums)):
            if nums[i] < nums[min_index]:
                min_index = i

        nums[min_index] *= multiplier

    return nums


# Example
nums = [2, 1, 3, 5, 6]
k = 5
multiplier = 2

print(getFinalState(nums, k, multiplier))
