# Leetcode Problem 1941
# Check if All Characters Have Equal Number of Occurrences 

class Solution(object):
    def areOccurrencesEqual(self, s):
        count = {}
        for ch in s:
            if ch in count:
                count[ch] += 1
            else:
                count[ch] = 1
        freq = -1
        for value in count.values():
            if freq == -1:
                freq = value
            elif value != freq:
                return False
        return True