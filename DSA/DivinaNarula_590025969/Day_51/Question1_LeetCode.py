# Most Frequent Even Element

class Solution(object):
    def mostFrequentEven(self, nums):
        freq = {}

        for num in nums:
            if num % 2 == 0:
                freq[num] = freq.get(num, 0) + 1

        if not freq:
            return -1

        answer = -1
        max_count = 0

        for num in freq:
            if freq[num] > max_count or (freq[num] == max_count and num < answer):
                max_count = freq[num]
                answer = num

        return answer