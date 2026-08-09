<h2 align="center">Week 8 Day 1 (03/08/2026)</h2>

## 1. Final Array State After K Multiplication Operations I (LeetCode #3264)
A problem that teaches simulation and greedy selection techniques by repeatedly transforming the minimum element of an array. You are given an integer array nums, an integer k, and an integer multiplier. You need to perform k operations on nums. In each operation:
- Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
- Replace the selected minimum value x with x * multiplier.

This problem is commonly asked in interviews and helps build concepts like:
- Simulation
- Minimum tracking
- Iterative array updates

which are important for solving repeated-operation and state-transformation problems.

**Your task:** Return an integer array denoting the final state of nums after performing all k operations.

### Input
An integer array `nums`, an integer `k`, and an integer `multiplier`, as described above.

**Constraints:**
- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
- `1 <= k <= 10`
- `1 <= multiplier <= 5`

### Output
Return an integer array denoting the final state of nums after performing all k operations.

### Example

`nums = [2,1,3,5,6], k = 5, multiplier = 2` → Output: `[8,4,6,5,6]`

| Operation | Result |
|---|---|
| After operation 1 | [2, 2, 3, 5, 6] |
| After operation 2 | [4, 2, 3, 5, 6] |
| After operation 3 | [4, 4, 3, 5, 6] |
| After operation 4 | [4, 4, 6, 5, 6] |
| After operation 5 | [8, 4, 6, 5, 6] |

### Examples

**Input:**
```
nums = [2,1,3,5,6], k = 5, multiplier = 2
```
**Output:**
```
[8,4,6,5,6]
```

---

**Input:**
```
nums = [1,2], k = 3, multiplier = 4
```
**Output:**
```
[16,8]
```

---

## 2. The Quarry Smasher
A stone quarry contains rocks of different weights. The foreman repeatedly performs the following operation: pick the two heaviest rocks and smash them together. If both rocks have the same weight, both are destroyed. If the weights are different, the lighter rock is destroyed and the heavier rock remains with a new weight equal to the difference of the two weights. This process continues until there is at most one rock remaining.

This problem is commonly asked in interviews and helps build concepts like:
- Heaps / priority queues
- Greedy simulation
- Repeated max-pair reduction

which are important for solving problems that require repeatedly acting on the largest elements of a collection.

**Your task:** Return the weight of the last remaining rock. If all rocks are destroyed, return 0.

### Input
An integer array `rocks`, as described above.

**Constraints:**
- `1 <= rocks.length <= 10000`
- `1 <= rocks[i] <= 1000`

### Output
Return the weight of the last remaining rock, or 0 if all rocks are destroyed.

### Examples

**Input:**
```
rocks = [2, 7, 4, 1, 8, 1]
```
**Output:**
```
1
```
**Explanation:** Smash 8 and 7 -> new rock = 1. Rocks = [4, 2, 1, 1, 1]. Smash 4 and 2 -> new rock = 2. Rocks = [2, 1, 1, 1]. Smash 2 and 1 -> new rock = 1. Rocks = [1, 1, 1]. Smash 1 and 1 -> both destroyed. Rocks = [1].

---

**Input:**
```
rocks = [10, 4, 2, 10]
```
**Output:**
```
2
```
**Explanation:** Smash 10 and 10 -> both destroyed. Rocks = [4, 2]. Smash 4 and 2 -> new rock = 2. Rocks = [2].

---

**Input:**
```
rocks = [1, 1]
```
**Output:**
```
0
```
**Explanation:** Smash 1 and 1 -> both destroyed. No rocks remain.

---
