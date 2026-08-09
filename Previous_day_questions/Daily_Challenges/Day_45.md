<h2 align="center">Week 7 Day 45 (29/07/2026)</h2>

## 1. Search Insert Position (LeetCode #35)
A problem that teaches binary search techniques by finding the position of a target value in a sorted array or the position where it should be inserted. Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You must write an algorithm with O(log n) runtime complexity.

This problem is commonly asked in interviews and helps build concepts like:
- Binary search
- Sorted array traversal
- Boundary handling

which are important for solving efficient search and insertion-point problems.

**Your task:** Return the index of target in nums, or the index where it would be inserted to keep nums sorted.

### Input
A sorted integer array `nums` and an integer `target`, as described above.

**Constraints:**
- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- nums contains distinct values sorted in ascending order.
- `-10^4 <= target <= 10^4`

### Output
Return the index of target if found, otherwise the index where it would be inserted.

### Examples

**Input:**
```
nums = [1,3,5,6], target = 5
```
**Output:**
```
2
```

---

**Input:**
```
nums = [1,3,5,6], target = 2
```
**Output:**
```
1
```

---

**Input:**
```
nums = [1,3,5,6], target = 7
```
**Output:**
```
4
```

---

## 2. Count Inversions in an Array
A merge sort and divide and conquer problem that requires counting the number of inversions in an array efficiently. You are given an array of integers. A pair (i, j) is called an inversion if i < j and arr[i] > arr[j]. An inversion represents a pair of elements that are out of order.

This problem is commonly asked in interviews and helps build concepts like:
- Divide and conquer
- Modified merge sort
- Pair counting

which are important for solving efficient counting and ordering problems.

**Your task:** Find the total number of inversions present in the given array.

### Input
An integer array `arr`, as described above.

**Constraints:**
- `1 <= n <= 100000`
- `-10^9 <= arr[i] <= 10^9`

### Output
Return the total number of inversions in arr.

### Examples

**Input:**
```
arr = [2, 4, 1, 3, 5]
```
**Output:**
```
3
```
**Explanation:** The inversions are (2,1), (4,1), and (4,3), so the total number of inversions is 3.

---

**Input:**
```
arr = [5, 4, 3, 2, 1]
```
**Output:**
```
10
```
**Explanation:** Every pair forms an inversion since the array is sorted in descending order. For n = 5, the total is 5 x (5 - 1) / 2 = 10.

---

**Input:**
```
arr = [1, 2, 3, 4, 5]
```
**Output:**
```
0
```
**Explanation:** The array is already sorted in ascending order, so there are no inversions.

---
