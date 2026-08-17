# Leetcode Problem 2099
# Find Subsequence of Length K With the Largest Sum 

class Solution(object):
    def maxSubsequence(self, nums, k):
        a = sorted(nums, reverse=True)
        b = a[:k]
        result = []
        
        for num in nums:
            if num in b:
                result.append(num)
                b.remove(num)
        return result