# Find Subsequence of Length K With the Largest Sum

class Solution(object):
    def maxSubsequence(self, nums, k):
        selected = sorted(range(len(nums)), key=lambda i: nums[i], reverse=True)[:k]
        selected.sort()
        return [nums[i] for i in selected]