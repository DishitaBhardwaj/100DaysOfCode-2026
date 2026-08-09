class Solution:
    def maxSubsequence(self, nums, k):
        indexed = []
        for i in range(len(nums)):
            indexed.append((nums[i], i))
        
        indexed.sort(key=lambda x: x[0], reverse=True)
        
        top_k = indexed[:k]
        
        top_k.sort(key=lambda x: x[1])
        
        return [val for val, idx in top_k]