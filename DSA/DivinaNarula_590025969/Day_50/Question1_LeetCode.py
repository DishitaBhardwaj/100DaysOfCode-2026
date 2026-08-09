# Final Array State After K Multiplication Operations I

import heapq

class Solution(object):
    def getFinalState(self, nums, k, multiplier):
        """
        :type nums: List[int]
        :type k: int
        :type multiplier: int
        :rtype: List[int]
        """
        
        heap = []

        for i, num in enumerate(nums):
            heapq.heappush(heap, (num, i))

        for _ in range(k):
            value, index = heapq.heappop(heap)
            value *= multiplier
            nums[index] = value
            heapq.heappush(heap, (value, index))

        return nums