<h2 align="center">Week 7 Day 43 (27/07/2026)</h2>

## 1. Merge Sorted Array

### Solution

```python
def merge(nums1, m, nums2, n):
    # Start filling from the back of nums1
    i = m - 1         # last valid element in nums1
    j = n - 1          # last element in nums2
    k = m + n - 1      # last position in nums1

    while j >= 0:
        if i >= 0 and nums1[i] > nums2[j]:
            nums1[k] = nums1[i]
            i -= 1
        else:
            nums1[k] = nums2[j]
            j -= 1
        k -= 1

    return nums1


# Test cases
print(merge([1,2,3,0,0,0], 3, [2,5,6], 3))  # [1,2,2,3,5,6]
print(merge([1], 1, [], 0))                  # [1]
print(merge([0], 0, [1], 1))                 # [1]
```

Why this works: since `nums1` has extra space at the end, filling from the back avoids overwriting elements we still need to compare. We compare the largest remaining elements of both arrays and place the bigger one at the end. If `nums2` still has elements left after `nums1` runs out, we copy them over (no need to handle leftover `nums1` elements — they're already in place).

Complexity: O(m + n) time, O(1) extra space.

---

## 2. Maximize Sum of Pair Minimums

### Solution

```python
def maxSumPairMin(nums):
    nums.sort()
    return sum(nums[0::2])  # sum every element at even index (0, 2, 4, ...)


# Test cases
print(maxSumPairMin([1, 4, 3, 2]))       # 4
print(maxSumPairMin([6, 2, 6, 5, 1, 2])) # 9
print(maxSumPairMin([1, 2, 3, 4]))       # 4
```

Why this works: sort the array, then pair up consecutive elements: `(nums[0], nums[1])`, `(nums[2], nums[3])`, etc. In each pair the smaller element is the one at the even index. This greedy pairing maximizes the sum of minimums — pairing a small number with a slightly larger one "wastes" as little of the larger number's value as possible, since it doesn't get counted anyway. Any other pairing strategy either keeps the same sum or does worse, because you'd be forcing a larger element to be "wasted" against an even larger one instead of a close neighbor.

Complexity: O(n log n) time (dominated by sorting), O(1) extra space (ignoring sort's internal space).
