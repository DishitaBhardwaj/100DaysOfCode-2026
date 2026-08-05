# Check if All Characters Have Equal Number of Occurrences

class Solution(object):
    def areOccurrencesEqual(self, s):
        """
        :type s: str
        :rtype: bool
        """
        freq = {}

        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        first = next(iter(freq.values()))

        for count in freq.values():
            if count != first:
                return False

        return True