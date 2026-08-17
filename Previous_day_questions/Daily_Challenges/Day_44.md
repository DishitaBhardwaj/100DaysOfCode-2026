<h2 align="center">Week 7 Day 2 (28/07/2026)</h2>

## 1. Can Make Arithmetic Progression From Sequence (LeetCode #1502)
A problem that teaches sorting and array-property verification techniques by determining whether an array can be rearranged into an evenly-spaced sequence. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same. Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Difference checking
- Sequence validation

which are important for solving pattern-recognition and array-validation problems.

**Your task:** Determine whether the array arr can be rearranged to form an arithmetic progression.

### Input
An integer array `arr`, as described above.

**Constraints:**
- `2 <= arr.length <= 1000`
- `-10^6 <= arr[i] <= 10^6`

### Output
Return true if arr can be rearranged to form an arithmetic progression, otherwise return false.

### Examples

**Input:**
```
arr = [3,5,1]
```
**Output:**
```
true
```

---

**Input:**
```
arr = [1,2,4]
```
**Output:**
```
false
```

---

## 2. Favourite Number
A sorting and counting problem that requires determining whether a favorite element will definitely be removed, definitely stay, or could be either after sorting. You are given an array nums of size n. One of the elements is marked as your favorite element (1-indexed). First, sort the array in descending order (largest to smallest). If multiple elements have the same value, they can appear in any order among themselves. After sorting, remove the first k elements from the array. Since equal elements can be arranged in any order, the favorite element's fate may depend on tiebreaking.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Frequency counting
- Boundary/tiebreak analysis

which are important for solving problems involving ambiguous ordering and rank-based decisions.

**Your task:** Determine whether the favorite element is definitely removed (return "YES"), definitely not removed (return "NO"), or may or may not be removed (return "MAYBE").

### Input
An integer array `nums`, an integer `favoriteIndex`, and an integer `k`, as described above.

**Constraints:**
- `1 <= n <= 100`
- `1 <= favoriteIndex <= n`
- `1 <= k <= n`
- `1 <= nums[i] <= 100`

### Output
Return "YES", "NO", or "MAYBE" as described above.

### Examples

**Input:**
```
nums = [4, 3, 3, 2, 3]
favoriteIndex = 2
k = 2
```
**Output:**
```
MAYBE
```

---

**Input:**
```
nums = [4, 2, 1, 3, 5]
favoriteIndex = 5
k = 3
```
**Output:**
```
YES
```

---

**Input:**
```
nums = [5, 2, 4, 1, 3]
favoriteIndex = 5
k = 2
```
**Output:**
```
NO
```

---
