class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        a=[]
        for i in range(len(nums)):
            a.append((nums[i],i))
        a.sort(reverse=True)
        a=a[:k]
        b=[]
        for i in a:
            b.append(i[1])
        b.sort()
        ans=[]
        for i in b:
            ans.append(nums[i])
        return ans
