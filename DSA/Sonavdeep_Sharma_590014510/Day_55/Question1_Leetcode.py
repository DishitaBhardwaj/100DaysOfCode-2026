class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        a = sorted(nums, reverse=True)[:k]
        ans = []

        for x in nums:
            if x in a:
                ans.append(x)
                a.remove(x)

        return ans