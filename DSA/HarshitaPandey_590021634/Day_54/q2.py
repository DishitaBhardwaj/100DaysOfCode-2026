class Solution(object):
    def maxFrequencyElements(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        counts= {}

        for num in nums:
            if num in counts:
                counts[num] += 1

            else:
                counts[num] = 1

        freqn = counts.values()
        maximum = max(freqn)

        total_freq=0
        for freq in freqn:
            if freq == maximum:
                total_freq += freq

        return total_freq