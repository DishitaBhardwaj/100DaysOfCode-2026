from typing import List


def maximize_prefix_difference(arr: List[int]) -> List[int]:
    n = len(arr)
    if n <= 1:
        return arr

    max_idx = max(range(n), key=lambda i: arr[i])
    arr[0], arr[max_idx] = arr[max_idx], arr[0]

    min_idx = min(range(1, n), key=lambda i: arr[i])
    arr[1], arr[min_idx] = arr[min_idx], arr[1]

    return arr


print(maximize_prefix_difference([3, 1, 4, 1, 5]))