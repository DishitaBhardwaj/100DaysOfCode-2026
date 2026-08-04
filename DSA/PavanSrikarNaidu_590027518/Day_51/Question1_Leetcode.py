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

        ans = -1
        freq = 0

        for num, c in count.items():
            if c > freq or (c == freq and num < ans):
                freq = c
                ans = num

        return ans