# Count Elements With Maximum Frequency

from collections import Counter

class Solution(object):
    def maxFrequencyElements(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        freq = Counter(nums)
        max_freq = max(freq.values())

        total = 0
        for count in freq.values():
            if count == max_freq:
                total += count

        return total