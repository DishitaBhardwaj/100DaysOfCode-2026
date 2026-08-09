# Intersection of Two Arrays

class Solution(object):
    def intersection(self, nums1, nums2):
        nums1_set = set(nums1)
        nums2_set = set(nums2)
        
        return list(nums1_set & nums2_set)