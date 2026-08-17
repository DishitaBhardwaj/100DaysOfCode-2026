<h2 align="center">Week 7 Day 49 (02/08/2026)</h2>

## 1. The Web of Chaos — Merge Sort & Binary Search (Bug Fix, No `while`)

### Bugs found in the original code

1. **`merge`**: the comparison `if left_part[i] > right_part[j]` picks the *larger* value first — that produces a descending merge instead of ascending. It needed to be `<=`.
2. **`merge`**: the final drain loop `while j < len(right_part): arr[k] = left_part[j]` reads from `left_part` instead of `right_part` — an out-of-bounds / wrong-value bug.
3. **`binary_search`**: uses `while low < high`, which can terminate one step early and never actually test `arr[mid] == target` on the final candidate in some cases — the loop condition should allow `low == high` to still be checked. Rewriting it recursively with `low <= high` as the base condition fixes this cleanly.
4. **The `while` keyword itself** is forbidden per the constraints, so all three `while` loops in `merge` and the one in `binary_search` had to be replaced with recursion.

### Solution

```python
def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    _merge_step(arr, left_part, right_part, 0, 0, left)


def _merge_step(arr, left_part, right_part, i, j, k):
    # Recursive replacement for the three `while` loops in the original merge
    if i < len(left_part) and j < len(right_part):
        if left_part[i] <= right_part[j]:
            arr[k] = left_part[i]
            i += 1
        else:
            arr[k] = right_part[j]
            j += 1
        _merge_step(arr, left_part, right_part, i, j, k + 1)
    elif i < len(left_part):
        arr[k] = left_part[i]
        _merge_step(arr, left_part, right_part, i + 1, j, k + 1)
    elif j < len(right_part):
        arr[k] = right_part[j]
        _merge_step(arr, left_part, right_part, i, j + 1, k + 1)
    # else: both halves exhausted, recursion ends


def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)


def binary_search(arr, target, low=0, high=None):
    if high is None:
        high = len(arr) - 1

    if low > high:
        return -1

    mid = (low + high) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search(arr, target, mid + 1, high)
    else:
        return binary_search(arr, target, low, mid - 1)


# ---- Driver ----
incidents = [34, 7, 23, 32, 5, 62, 15]
merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23))
```

### Output

```
Sorted Reports: [5, 7, 15, 23, 32, 34, 62]
Record Found At: 3
```

Matches the expected output exactly, and no `while` keyword appears anywhere in the solution — both the merge-drain steps and the binary search are done with recursion instead.

Complexity: O(n log n) time for `merge_sort`, O(log n) time for `binary_search`, O(n) extra space (for the merge buffers and recursion stack).
