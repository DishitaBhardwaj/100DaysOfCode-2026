# Leetcode Problem 3005
# Count Elements With Maximum Frequency 

class Solution(object):
    def maxFrequencyElements(self, nums):
        freq = {}
        for num in nums:
            if num in freq:
                freq[num] += 1
            else:
                freq[num] = 1
        max_freq = max(freq.values())
        ans = 0
        for num in freq:
            if freq[num] == max_freq:
                ans += freq[num]
        return ans