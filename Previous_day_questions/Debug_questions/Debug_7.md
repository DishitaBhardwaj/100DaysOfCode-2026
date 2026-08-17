<h2 align="center">Week 7 Day 7 (02/08/2026)</h2>

## The Web of Chaos

New York's crime tracking system keeps incident reports sorted and searchable so Spider-Man can locate villains quickly. During a failed experiment, Spider-Man transformed into Man-Spider and rampaged through the crime tracking centre, tangling the source code in layers of webbing.

Venom found the damage: some incident reports were stuck to the wrong side of the database, some records became trapped while moving between arrays, and certain search paths appeared blocked. Worst of all, the `while` keyword was completely covered in webbing and can no longer be used anywhere.

You are the systems analyst. Untangle the code before the villains slip through the cracks.

This problem is commonly asked in interviews and helps build concepts like:
- Merge Sort
- Binary Search
- Debugging and code tracing
- Iterative-to-recursive conversion

which are important for solving correctness and refactoring problems under constraints.

**Your task:** Identify and fix all logical bugs in the code below, and rewrite it so that it no longer uses the `while` keyword anywhere.

### What the code must do
- Identify and fix all logical bugs.
- Ensure Merge Sort correctly sorts the array.
- Ensure Binary Search correctly locates elements.
- Remove ALL uses of the `while` keyword — any solution containing `while` is considered incorrect.

### Buggy Code

```python
def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    i = j = 0; k = left
    while i < len(left_part) and j < len(right_part):
        if left_part[i] > right_part[j]:
            arr[k] = left_part[i]; i += 1
        else:
            arr[k] = right_part[i]; j += 1
        k += 1
    while i < len(left_part):
        arr[k] = left_part[i]; i += 1; k += 1
    while j < len(right_part):
        arr[k] = left_part[j]; j += 1; k += 1

def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid); merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def binary_search(arr, target):
    low, high = 0, len(arr) - 1
    while low < high:
        mid = (low + high + 1) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid
    return -1

incidents = [34, 7, 23, 32, 5, 62, 15]
merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23))
```

### Expected Output

```
Sorted Reports: [5, 7, 15, 23, 32, 34, 62]
Record Found At: 3
```

### Constraints
- `1 <= n <= 10^5`
- Incident IDs are integers.
- Sorting must use Merge Sort; searching must use Binary Search.
- The `while` keyword is forbidden — replace with for loops or recursion.
- Return -1 if the target does not exist.

---
