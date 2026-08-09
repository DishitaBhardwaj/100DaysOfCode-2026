<h2 align="center">Week 7 Day 5 (31/07/2026)</h2>

## 1. Relative Ranks (LeetCode #506)
A problem that teaches sorting and mapping techniques by assigning medal-based or numeric ranks to competitors based on their scores. You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique. The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
- The 1st place athlete's rank is "Gold Medal".
- The 2nd place athlete's rank is "Silver Medal".
- The 3rd place athlete's rank is "Bronze Medal".
- For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Index mapping
- Rank assignment

which are important for solving ranking and ordering problems efficiently.

**Your task:** Return an array answer of size n where answer[i] is the rank of the ith athlete.

### Input
An integer array `score`, as described above.

**Constraints:**
- `n == score.length`
- `1 <= n <= 10^4`
- `0 <= score[i] <= 10^6`
- All the values in score are unique.

### Output
Return an array answer of size n where answer[i] is the rank of the ith athlete.

### Examples

**Input:**
```
score = [5,4,3,2,1]
```
**Output:**
```
["Gold Medal","Silver Medal","Bronze Medal","4","5"]
```

---

## 2. K-th Smallest Element in Two Sorted Arrays
A binary search problem that requires finding the k-th smallest element from two sorted arrays without merging them. You are given two sorted arrays A and B (both in ascending order) and an integer k. Your task is to determine the k-th smallest element in the combined sorted order of both arrays.

This problem is commonly asked in interviews and helps build concepts like:
- Binary search
- Divide and conquer
- Two-pointer techniques

which are important for solving efficient order-statistics problems on multiple sorted arrays.

**Your task:** Find the k-th smallest element across both sorted arrays without merging them.

### Input
Two sorted integer arrays `A` and `B`, and an integer `k`, as described above.

**Constraints:**
- `1 <= len(A), len(B) <= 100000`
- `1 <= k <= len(A) + len(B)`
- Elements are distinct
- Both arrays are sorted in ascending order

### Output
Return the k-th smallest element across both sorted arrays.

### Examples

**Input:**
```
A = [2, 3, 6, 7]
B = [1, 4, 5, 8]
k = 5
```
**Output:**
```
5
```

---

**Input:**
```
A = [1, 3]
B = [2]
k = 2
```
**Output:**
```
2
```

---

**Input:**
```
A = [10, 20, 30]
B = [5, 15, 25]
k = 4
```
**Output:**
```
20
```

---
