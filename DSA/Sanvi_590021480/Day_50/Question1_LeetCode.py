class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        for i in range(k):
            a=nums.index(min(nums))
            nums[a]=nums[a]*multiplier
            
        return nums

        
