class Solution:
    def intersection(self, nums1, nums2):
        return list(set(nums1) & set(nums2))


# For VS Code testing
if __name__ == "__main__":
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]

    sol = Solution()
    print(sol.intersection(nums1, nums2))