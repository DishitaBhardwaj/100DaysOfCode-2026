<h2 align="center">Week 7 Day 4 (30/07/2026)</h2>

## 1. Intersection of Two Arrays (LeetCode #349)
A problem that teaches hashing and set techniques by finding the unique elements common to two arrays. Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

This problem is commonly asked in interviews and helps build concepts like:
- Hash sets
- Array traversal
- Duplicate handling

which are important for solving efficient set-based array problems.

**Your task:** Return an array containing the unique elements present in both nums1 and nums2.

### Input
Two integer arrays `nums1` and `nums2`, as described above.

**Constraints:**
- `1 <= nums1.length <= 1000`
- `1 <= nums2.length <= 1000`
- `0 <= nums1[i] <= 1000`
- `0 <= nums2[i] <= 1000`

### Output
Return an array of the unique elements in the intersection of nums1 and nums2, in any order.

### Examples

**Input:**
```
nums1 = [1,2,2,1], nums2 = [2,2]
```
**Output:**
```
[2]
```

---

**Input:**
```
nums1 = [4,9,5], nums2 = [9,4,9,8,4]
```
**Output:**
```
[9,4]
```

---

## 2. Maximum Prefix Difference Score
A sorting and observation-based problem that requires maximizing a score by rearranging the elements of an array. You are given an array nums of size n. Before doing any calculations, you are allowed to rearrange the elements of the array in any order. After rearranging, create two new arrays: minPrefix[i] = the minimum element among the first i+1 elements, and maxPrefix[i] = the maximum element among the first i+1 elements. The score is the sum of (maxPrefix[i] - minPrefix[i]) for all i.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Greedy arrangement
- Prefix computation

which are important for solving optimization problems involving array rearrangement.

**Your task:** Rearrange the array optimally and find the maximum possible score.

### Input
An integer array `nums`, as described above.

**Constraints:**
- `1 <= n <= 1000`
- `1 <= nums[i] <= 1000`

### Output
Return the maximum possible score after optimally rearranging nums.

### Examples

**Input:**
```
nums = [5]
```
**Output:**
```
0
```

---

**Input:**
```
nums = [7, 6, 5]
```
**Output:**
```
4
```

---

**Input:**
```
nums = [1, 1, 1, 2, 2]
```
**Output:**
```
4
```

---
