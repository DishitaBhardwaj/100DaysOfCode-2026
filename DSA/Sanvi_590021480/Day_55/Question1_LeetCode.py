class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        largest=sorted(nums,reverse=True)[:k]
        ans=[]
        for i in nums:
            if i in largest:
                ans.append(i)
                largest.remove(i)
        return ans
