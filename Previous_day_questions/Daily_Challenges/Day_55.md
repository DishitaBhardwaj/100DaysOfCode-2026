<h2 align="center">Week 8 Day 6 (08/08/2026)</h2>

## 1. Find Subsequence of Length K With the Largest Sum (LeetCode #2099)
A problem that teaches sorting and index-tracking techniques by selecting the highest-value elements of an array while preserving their original order. You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum. Return any such subsequence as an integer array of length k. A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting with index tracking
- Greedy selection
- Order preservation

which are important for solving problems that combine value selection with order-preserving constraints.

**Your task:** Return any subsequence of nums of length k that has the largest possible sum.

### Input
An integer array `nums` and an integer `k`, as described above.

**Constraints:**
- `1 <= nums.length <= 1000`
- `-10^5 <= nums[i] <= 10^5`
- `1 <= k <= nums.length`

### Output
Return a subsequence of nums of length k with the largest possible sum, keeping the original relative order.

### Examples

**Input:**
```
nums = [2,1,3,3], k = 2
```
**Output:**
```
[3,3]
```

---

**Input:**
```
nums = [-1,-2,3,4], k = 3
```
**Output:**
```
[-1,3,4]
```

---

**Input:**
```
nums = [3,4,3,3], k = 2
```
**Output:**
```
[3,4]
```

---

## 2. Maximum Playlist Pleasure
You have a playlist containing n songs. Each song is described by two values: length[i] (the duration of the song) and beauty[i] (the beauty rating of the song). You are allowed to select at most k songs from the playlist. After selecting a set of songs, the pleasure of that set is calculated as: Pleasure = (Sum of lengths of selected songs) x (Minimum beauty among selected songs). Your goal is to choose the songs in such a way that the pleasure is as large as possible.

This problem is commonly asked in interviews and helps build concepts like:
- Sorting
- Heaps / priority queues
- Greedy optimization with a minimum constraint

which are important for solving problems that optimize a product involving a sum and a minimum.

**Your task:** Find the maximum pleasure that can be obtained by selecting at most k songs.

### Input
Two integer arrays `length` and `beauty`, and an integer `k`, as described above.

**Constraints:**
- `1 <= k <= n <= 300000`
- `1 <= length[i] <= 1000000`
- `1 <= beauty[i] <= 1000000`

### Output
Return the maximum pleasure obtainable by selecting at most k songs.

### Examples

**Input:**
```
length = [4, 15, 3, 6]
beauty = [7, 1, 6, 8]
k = 3
```
**Output:**
```
78
```

---

**Input:**
```
length = [12, 112, 100, 13, 55]
beauty = [31, 4, 100, 55, 50]
k = 3
```
**Output:**
```
10000
```

---
