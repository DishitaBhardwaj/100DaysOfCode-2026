<h2 align="center">Week 6 Day 6 (25/07/2026)</h2>

## 1. Design Circular Queue (LeetCode #622)
A problem that teaches data structure design and circular buffer techniques by implementing a fixed-size queue that reuses freed space at the front. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called a "Ring Buffer". One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values. Implement the MyCircularQueue class:
- `MyCircularQueue(k)` Initializes the object with the size of the queue to be k.
- `int Front()` Gets the front item from the queue. If the queue is empty, return -1.
- `int Rear()` Gets the last item from the queue. If the queue is empty, return -1.
- `boolean enQueue(int value)` Inserts an element into the circular queue. Return true if the operation is successful.
- `boolean deQueue()` Deletes an element from the circular queue. Return true if the operation is successful.
- `boolean isEmpty()` Checks whether the circular queue is empty or not.
- `boolean isFull()` Checks whether the circular queue is full or not.

This problem is commonly asked in interviews and helps build concepts like:
- Circular buffers
- Data structure design
- Pointer/index management

which are important for solving problems that require fixed-size, space-efficient queues.

**Your task:** Implement the MyCircularQueue class described above without using the built-in queue data structure in your programming language.

### Input
A sequence of method calls (MyCircularQueue, enQueue, deQueue, Front, Rear, isEmpty, isFull) with their corresponding arguments, as described above.

**Constraints:**
- `1 <= k <= 1000`
- `0 <= value <= 1000`
- At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

### Output
Return the result of each call, as described above.

### Examples

**Input:**
```
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
```
**Output:**
```
[null, true, true, true, false, 3, true, true, true, 4]
```

---

## 2. Office Printer Wars
A queue simulation problem that requires determining which department remains after repeatedly canceling rival print jobs. Two departments, Sales and Marketing, share a single office printer. All print jobs are placed in a queue in the order they were submitted. Each job belongs to either S (Sales) or M (Marketing). The printing process follows these rules: the job at the front of the queue is processed; after its job is completed, that department immediately cancels the next pending job belonging to the rival department; the department whose job was processed remains active and waits for its future turns. This process continues until all jobs from one department have been removed.

This problem is commonly asked in interviews and helps build concepts like:
- Queue simulation
- Two-pointer/counting techniques
- Turn-based elimination logic

which are important for solving simulation and elimination-based queue problems.

**Your task:** Given the initial queue of jobs, determine which department will be the last one remaining.

### Input
A string `jobs`, as described above.

**Constraints:**
- `1 <= jobs.length <= 10000`
- `jobs[i]` is either `'S'` (Sales) or `'M'` (Marketing)

### Output
Return the name of the department that remains last: `"Sales"` or `"Marketing"`.

### Examples

**Input:**
```
jobs = "SM"
```
**Output:**
```
Sales
```

---

**Input:**
```
jobs = "SMM"
```
**Output:**
```
Marketing
```

---

**Input:**
```
jobs = "MSS"
```
**Output:**
```
Sales
```

---
