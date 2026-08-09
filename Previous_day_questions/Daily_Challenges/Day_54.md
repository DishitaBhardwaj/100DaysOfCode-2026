<h2 align="center">Week 8 Day 5 (07/08/2026)</h2>

## 1. Count Elements With Maximum Frequency (LeetCode #3005)
A problem that teaches hashing and frequency counting techniques by summing up the occurrences of the most frequent elements in an array. You are given an array nums consisting of positive integers. Return the total frequencies of elements in nums such that those elements all have the maximum frequency. The frequency of an element is the number of occurrences of that element in the array.

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- Frequency counting
- Maximum tracking

which are important for solving frequency-distribution and aggregation problems.

**Your task:** Return the total frequencies of elements in nums that have the maximum frequency.

### Input
An integer array `nums`, as described above.

**Constraints:**
- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`

### Output
Return the total frequencies of the elements that have the maximum frequency.

### Examples

**Input:**
```
nums = [1,2,2,3,1,4]
```
**Output:**
```
4
```

---

**Input:**
```
nums = [1,2,3,4,5]
```
**Output:**
```
5
```

---

## 2. Football Championship Winner
A football final was played between two teams. You are given a list containing the team name for every goal scored during the match. The team that scores more goals wins the match. It is guaranteed that the match does not end in a draw, and the goal list contains names of at most two different teams.

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- Frequency counting
- Simple majority determination

which are important for solving basic counting and comparison problems.

**Your task:** Determine the name of the team that won the match.

### Input
A list of strings `goals`, as described above.

**Constraints:**
- `1 <= n <= 100`
- `1 <= teamName.length <= 10`
- Team names contain only uppercase English letters.

### Output
Return the name of the team that won the match.

### Examples

**Input:**
```
goals = ["ABC"]
```
**Output:**
```
ABC
```

---

**Input:**
```
goals = ["A", "ABA", "ABA", "A", "A"]
```
**Output:**
```
A
```

---

**Input:**
```
goals = ["LIONS", "TIGERS", "LIONS", "LIONS"]
```
**Output:**
```
LIONS
```

---
