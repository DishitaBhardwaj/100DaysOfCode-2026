<h2 align="center">Week 7 Day 1 (27/07/2026)</h2>

## 1. Merge Sorted Array (LeetCode #88)
A problem that teaches in-place merging and two-pointer techniques by combining two sorted arrays into one sorted array. You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order. The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

This problem is commonly asked in interviews and helps build concepts like:
- Two-pointer technique
- In-place array merging
- Reverse iteration

which are important for solving space-efficient array manipulation problems.

**Your task:** Merge nums1 and nums2 into a single array sorted in non-decreasing order, storing the result in place inside nums1.

### Input
Two integer arrays `nums1` and `nums2`, and two integers `m` and `n`, as described above.

**Constraints:**
- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

### Output
Return the merged, sorted array stored in nums1.

**Follow up:** Can you come up with an algorithm that runs in O(m + n) time?

### Examples

**Input:**
```
nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
```
**Output:**
```
[1,2,2,3,5,6]
```

---

**Input:**
```
nums1 = [1], m = 1, nums2 = [], n = 0
```
**Output:**
```
[1]
```

---

**Input:**
```
nums1 = [0], m = 0, nums2 = [1], n = 1
```
**Output:**
```
[1]
```

---

## 2. Maximize Sum of Pair Minimums
A sorting problem that requires forming pairs to maximize the sum of pair minimums. You are given an array of 2n integers. Pair up all the elements into exactly n pairs. For each pair, consider the smaller of the two elements. Your score is the sum of these minimum values. Your task is to find the maximum possible score.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Greedy pairing strategies
- Optimization

which are important for solving array-partitioning and optimization problems.

**Your task:** Pair all elements into exactly n pairs such that the sum of the minimum element from each pair is maximized.

### Input
An integer array `nums` of length `2n`, as described above.

**Constraints:**
- `1 <= n <= 10000`
- `nums.length = 2 x n`
- `-10^4 <= nums[i] <= 10^4`

### Output
Return the maximum possible sum of the minimum values of each pair.

### Examples

**Input:**
```
nums = [1, 4, 3, 2]
```
**Output:**
```
4
```

---

**Input:**
```
nums = [6, 2, 6, 5, 1, 2]
```
**Output:**
```
9
```

---

**Input:**
```
nums = [1, 2, 3, 4]
```
**Output:**
```
4
```

---
