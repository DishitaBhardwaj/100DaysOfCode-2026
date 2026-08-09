class Solution:
    def maximumPrefixDifferenceScore(self, nums):
        if len(nums) <= 1:
            return 0
        return (len(nums) - 1) * (max(nums) - min(nums))