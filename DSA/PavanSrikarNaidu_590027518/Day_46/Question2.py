class Solution:
    def maxPrefixDifferenceScore(self, nums):
        nums.sort()

        ans = 0
        mn = mx = nums[0]

        for x in nums:
            mn = min(mn, x)
            mx = max(mx, x)
            ans += mx - mn

        return ans


# For VS Code testing
if __name__ == "__main__":
    nums = [7, 6, 5]
    sol = Solution()
    print(sol.maxPrefixDifferenceScore(nums))