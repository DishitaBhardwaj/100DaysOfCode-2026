def SortedSquare(nums):
    left = 0
    right = len(nums) - 1
    res = [0] * len(nums)
    write_idx = len(res) - 1

    while left <= right:
        if abs(nums[left]) > abs(nums[right]):
            res[write_idx] = nums[left] **2
            left += 1
        else:
            res[write_idx] = nums[right] **2
            right -= 1
        write_idx -= 1

    return res