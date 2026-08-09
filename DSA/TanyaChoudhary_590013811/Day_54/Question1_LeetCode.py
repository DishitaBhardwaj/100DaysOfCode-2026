class Solution:
    def maxFrequencyElements(self, nums):
        count = {}
        
        for num in nums:
            count[num] = count.get(num, 0) + 1
        
        max_freq = max(count.values())
        
        total = 0
        for freq in count.values():
            if freq == max_freq:
                total += freq
        
        return total