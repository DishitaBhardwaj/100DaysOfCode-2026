<h2 align="center">Week 6 Day 5 (24/07/2026)</h2>

## 1. Design Front Middle Back Queue (LeetCode #1670)
A problem that teaches data structure design and deque techniques by building a queue that supports insertion and removal at the front, middle, and back. Design a queue that supports push and pop operations in the front, middle, and back. Implement the FrontMiddleBack class:
- `FrontMiddleBack()` Initializes the queue.
- `void pushFront(int val)` Adds val to the front of the queue.
- `void pushMiddle(int val)` Adds val to the middle of the queue.
- `void pushBack(int val)` Adds val to the back of the queue.
- `int popFront()` Removes the front element of the queue and returns it. If the queue is empty, return -1.
- `int popMiddle()` Removes the middle element of the queue and returns it. If the queue is empty, return -1.
- `int popBack()` Removes the back element of the queue and returns it. If the queue is empty, return -1.

Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example, pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5]. Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6].

This problem is commonly asked in interviews and helps build concepts like:
- Data structure design
- Doubly ended queues (deques)
- Amortized operations

which are important for solving problems that require efficient insertion and removal at multiple ends.

**Your task:** Implement the FrontMiddleBack class described above so that it correctly supports push and pop operations at the front, middle, and back of the queue.

### Input
A sequence of method calls (pushFront, pushMiddle, pushBack, popFront, popMiddle, popBack) with their corresponding arguments, as described above.

**Constraints:**
- `1 <= val <= 10^9`
- At most 1000 calls will be made to pushFront, pushMiddle, pushBack, popFront, popMiddle, and popBack.

### Output
Return the result of each call: push operations return null, and pop operations return the removed value (or -1 if the queue is empty).

### Examples

**Input:**
```
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
```
**Output:**
```
[null, null, null, null, null, 1, 3, 4, 2, -1]
```

---

## 2. Highest Temperature in Every Time Window
A deque and sliding window problem that requires finding the maximum temperature in every group of consecutive hours. A weather station records the temperature every hour. To analyze temperature trends, a meteorologist looks at every group of k consecutive hours and records the highest temperature observed during that period. Given an array temperatures containing hourly temperature readings and an integer k, find the maximum temperature in every contiguous window of size k.

This problem is commonly asked in interviews and helps build concepts like:
- Sliding window
- Monotonic deque
- Window maximum tracking

which are important for solving efficient range-query and windowing problems.

**Your task:** Return an array containing the maximum temperature for every contiguous subarray of length k.

### Input
An integer array `temperatures` and an integer `k`, as described above.

**Constraints:**
- `1 <= n <= 100000`
- `1 <= k <= n`
- `-10000 <= temperatures[i] <= 10000`

### Output
Return an array containing the maximum temperature for every contiguous window of size k.

### Examples

**Input:**
```
temperatures = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
```
**Output:**
```
[3, 3, 5, 5, 6, 7]
```

---

**Input:**
```
temperatures = [9, 11, 8, 5, 7, 10]
k = 2
```
**Output:**
```
[11, 11, 8, 7, 10]
```

---

**Input:**
```
temperatures = [4, 4, 4, 4]
k = 2
```
**Output:**
```
[4, 4, 4]
```

---
