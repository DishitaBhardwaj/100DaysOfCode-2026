# Leetcode Problem 3264
# Final Array State After K Multiplication Operations I 

class Solution(object):
    def getFinalState(self, nums, k, multiplier):
        n = len(nums)
        
        for i in range(k):
            p = 0
            for j in range(1, n):
                if nums[j] < nums[p]:
                    p = j
            nums[p] = nums[p] * multiplier
        return nums