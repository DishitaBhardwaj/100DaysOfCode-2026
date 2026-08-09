class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        maxi=0
        for i in nums:
            if nums.count(i)>maxi:
                maxi=nums.count(i)
        count=0
        for i in nums:
            if nums.count(i)==maxi:
                count=count+1
        return count
