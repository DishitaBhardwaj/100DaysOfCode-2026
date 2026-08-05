class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        a=[x for x in nums if x%2==0]
        if len(a)==0:
            return -1
        maxi=0
        ans=0
        a.sort()
        for i in a:
            if a.count(i)>maxi:
                maxi=a.count(i)
                ans=i
        return ans
