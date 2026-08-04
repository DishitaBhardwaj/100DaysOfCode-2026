class Solution:
    def getFinalState(self, nums, k, multiplier):
        for _ in range(k):
            min_idx = 0
            for i in range(1, len(nums)):
                if nums[i] < nums[min_idx]:
                    min_idx = i
            nums[min_idx] *= multiplier
        
        return nums