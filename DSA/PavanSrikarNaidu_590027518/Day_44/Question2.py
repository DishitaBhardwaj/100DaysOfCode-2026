class Solution:
    def favoriteNumber(self, nums, favoriteIndex, k):
        # favoriteIndex is 1-based
        favorite = nums[favoriteIndex - 1]

        nums.sort(reverse=True)

        total = nums.count(favorite)
        removed = nums[:k].count(favorite)

        if removed == total:
            return "YES"
        elif removed == 0:
            return "NO"
        else:
            return "MAYBE"


# For VS Code testing
if __name__ == "__main__":
    nums = [4, 2, 1, 3, 5]
    favoriteIndex = 5
    k = 3

    sol = Solution()
    print(sol.favoriteNumber(nums, favoriteIndex, k))