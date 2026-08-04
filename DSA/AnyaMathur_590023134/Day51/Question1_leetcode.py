# Leetcode Problem 2404 
# Most Frequent Even Element 

class Solution(object):
    def mostFrequentEven(self, nums):
        freq = {}

        for num in nums:
            if num % 2 == 0:
                if num in freq:
                    freq[num] += 1
                else:
                    freq[num] = 1

        ans = -1
        maxFreq = 0

        for num in sorted(freq):
            if freq[num] > maxFreq:
                maxFreq = freq[num]
                ans = num
        return ans