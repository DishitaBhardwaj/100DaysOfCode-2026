from typing import List
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        selected = sorted(nums, reverse=True)[:k]
        result = []
        for num in nums:
            if num in selected:
                result.append(num)
                selected.remove(num)        
        return result