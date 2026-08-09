class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        freq = {}

        for num in nums:
            if num % 2 == 0:
                if num in freq:
                    freq[num] += 1
                else:
                    freq[num] = 1

        ans = -1
        max_count = 0

        for num in freq:
            if freq[num] > max_count:
                max_count = freq[num]
                ans = num
            elif freq[num] == max_count and num < ans:
                ans = num

        return ans