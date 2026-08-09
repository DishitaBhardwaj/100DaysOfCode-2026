<h2 align="center">Week 8 Day 50 (03/08/2026)</h2>

## 1. Final Array State After K Multiplication Operations I (LeetCode #3264)

### Optimised Solution

A naive approach rescans the whole array to find the minimum on every one of the `k` operations, giving O(k · n). Since we repeatedly need "the current minimum, first-occurrence-wins on ties," a **min-heap keyed on `(value, index)`** does the job in O(k log n) — the index in the tuple naturally breaks ties in favor of the earliest occurrence, since heapq compares tuples element-wise.

```python
import heapq

def finalArray(nums, k, multiplier):
    heap = [(v, i) for i, v in enumerate(nums)]
    heapq.heapify(heap)

    for _ in range(k):
        v, i = heapq.heappop(heap)
        nums[i] = v * multiplier
        heapq.heappush(heap, (nums[i], i))

    return nums


# Test cases
print(finalArray([2, 1, 3, 5, 6], 5, 2))  # [8, 4, 6, 5, 6]
print(finalArray([1, 2], 3, 4))           # [16, 8]
```

How it works:

* Build a min-heap of `(value, original_index)` pairs — heapifying is O(n).
* Each operation pops the smallest pair (ties broken by the smaller index automatically, since tuples compare left-to-right), multiplies the value, writes it back into `nums` at that index, and pushes the updated pair back onto the heap.
* After `k` pops/pushes, `nums` holds the final state directly — no need to re-derive it from the heap.

Complexity: O(n + k log n) time, O(n) extra space. Given the constraints (`n ≤ 100`, `k ≤ 10`) this is already essentially instant, but it also scales cleanly if `k` were much larger — unlike the O(k·n) linear-scan approach.

---

## 2. The Quarry Smasher

### Optimised Solution

This is the classic "repeatedly smash the two heaviest" pattern — the natural fit is a **max-heap** (simulated in Python with negated values), since we always need the current two largest weights in O(log n) each rather than re-sorting or re-scanning the whole list every round.

```python
import heapq

def lastStoneStanding(rocks):
    heap = [-r for r in rocks]   # negate to turn min-heap into max-heap
    heapq.heapify(heap)

    while len(heap) > 1:
        y = -heapq.heappop(heap)  # heaviest
        x = -heapq.heappop(heap)  # second heaviest
        if y != x:
            heapq.heappush(heap, -(y - x))

    return -heap[0] if heap else 0


# Test cases
print(lastStoneStanding([2, 7, 4, 1, 8, 1]))  # 1
print(lastStoneStanding([10, 4, 2, 10]))       # 2
print(lastStoneStanding([1, 1]))               # 0
```

How it works:

* Push all rock weights onto a max-heap (via negation, since `heapq` is min-heap only).
* Repeatedly pop the two heaviest rocks. If they differ, push the difference back on; if equal, both vanish (nothing pushed).
* Stop when 0 or 1 rocks remain; return the last weight, or 0 if the heap is empty.

Complexity: O(n log n) time (n heap operations, each O(log n)), O(n) extra space — comfortably handles the max input size of `n = 10,000`.
