from collections import Counter

class Solution:
    def areOccurrencesEqual(self, s):
        counts = Counter(s)
        return len(set(counts.values())) == 1