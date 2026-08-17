from collections import Counter

class Solution:
    def mostFrequentEven(self, nums):
        count = Counter(n for n in nums if n % 2 == 0)
        if not count:
            return -1
        return min(count.keys(), key=lambda x: (-count[x], x))