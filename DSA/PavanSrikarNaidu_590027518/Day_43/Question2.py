class Solution:
    def arrayPairSum(self, nums):
        nums.sort()
        return sum(nums[::2])


# For VS Code testing
if __name__ == "__main__":
    nums = [1, 4, 3, 2]
    sol = Solution()
    print(sol.arrayPairSum(nums))