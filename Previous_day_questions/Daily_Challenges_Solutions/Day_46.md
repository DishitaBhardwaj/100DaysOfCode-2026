<h2 align="center">Week 7 Day 46 (29/07/2026)</h2>

## 1. Intersection of Two Arrays
### Solution
```python
def intersection(nums1, nums2):
    return list(set(nums1) & set(nums2))
```

* Time: O(n + m) — building each set is O(n)/O(m), intersection is O(min(n, m)).
* Space: O(n + m) for the sets.

This beats sort-and-two-pointer (O(n log n + m log m)) since array values are bounded (0–1000), but even without that constraint, hashing gives the best asymptotic time.

---

## 2. Maximum Prefix Difference Score
### Solution
```python
def max_prefix_diff_score(nums):
    n = len(nums)
    if n <= 1:
        return 0

    lo = hi = nums[0]
    for x in nums[1:]:
        if x < lo: lo = x
        if x > hi: hi = x

    return (n - 1) * (hi - lo)
```

* Time: O(n) — single pass, no sorting (sorting would cost O(n log n) for no benefit).
* Space: O(1) extra.

**Why this is truly optimal:** you must read every element at least once to know the min and max, so O(n) is a hard lower bound — this solution hits it exactly, with no wasted work (no full rearrangement of the array is ever actually performed, since the formula bypasses the need to).

**Quick correctness recap**
* `minPrefix[i]` can only shrink or stay the same as `i` grows; `maxPrefix[i]` can only grow or stay the same.
* Once both the true min and true max have appeared in the prefix, every later term contributes the full `(max - min)`.
* Placing min and max in the first two slots forces this maximal contribution for all `n-1` remaining positions, and no arrangement can do better (you can't get more than `max-min` per term, and you can't get it "sooner" than after 2 elements).
