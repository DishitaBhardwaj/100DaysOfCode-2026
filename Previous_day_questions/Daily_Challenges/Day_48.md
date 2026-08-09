<h2 align="center">Week 7 Day 6 (01/08/2026)</h2>

## 1. Sort the Students by Their Kth Score (LeetCode #2545)
A problem that teaches sorting techniques applied to matrices by ordering rows according to a specific column's values. There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only. You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest. Return the matrix after sorting it.

This problem is commonly asked in interviews and helps build concepts like:
- Custom sorting/comparators
- Matrix manipulation
- Column-based ordering

which are important for solving problems that require sorting structured data by a specific attribute.

**Your task:** Sort the rows of the matrix score by the kth column in descending order and return the sorted matrix.

### Input
A 0-indexed m x n integer matrix `score` and an integer `k`, as described above.

**Constraints:**
- `m == score.length`
- `n == score[i].length`
- `1 <= m, n <= 250`
- `1 <= score[i][j] <= 10^5`
- score consists of distinct integers.
- `0 <= k < n`

### Output
Return the matrix score sorted by the kth column from highest to lowest.

### Examples

**Input:**
```
score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
```
**Output:**
```
[[7,5,11,2],[10,6,9,1],[4,8,3,15]]
```

---

**Input:**
```
score = [[3,4],[5,6]], k = 0
```
**Output:**
```
[[5,6],[3,4]]
```

---

## 2. Assembly via Minimums
A sorting and observation based problem that requires reconstructing an original array from the minimum values of all possible pairs. You are given an array b that was created from a hidden array a of length n. For every pair of indices (i, j) where i < j, the value min(a[i], a[j]) was calculated and added to array b. After calculating the minimum for every possible pair, all elements of b were shuffled randomly.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Reverse construction
- Pattern deduction

which are important for solving reconstruction and inverse-relationship problems.

**Your task:** Given n and the shuffled array b, construct any valid array a of length n.

### Input
An integer `n` and an integer array `b`, as described above.

**Constraints:**
- `2 <= n <= 1000`
- `-10^9 <= b[i] <= 10^9`
- It is guaranteed that at least one valid original array exists.

### Output
Return any valid array a of length n consistent with b, as described above.

### Examples

**Input:**
```
n = 2
b = [5]
```
**Output:**
```
[5, 10]
```

---

**Input:**
```
n = 3
b = [4, 2, 2]
```
**Output:**
```
[2, 4, 100]
```

---
