class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s = set(nums1)
        ans = []

        for x in set(nums2):
            if x in s:
                ans.append(x)

        return ans