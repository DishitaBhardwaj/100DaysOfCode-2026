from collections import Counter
from typing import List

class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        count = Counter()
        for num in nums:
            if num % 2 == 0:
                count[num] += 1
        if not count:
            return -1
        max_freq = max(count.values())
        ans = float('inf')
        for num, freq in count.items():
            if freq == max_freq:
                ans = min(ans, num)
        return ans