class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        max=0
        for i in nums:
            if nums.count(i)>max:
                max=nums.count(i)
        count=0
        for i in nums:
            if nums.count(i)==max:
                count+=1
        return count
        
