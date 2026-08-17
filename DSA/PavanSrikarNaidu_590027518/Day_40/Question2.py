from collections import deque
from typing import List

def highest_temperature_in_window(temperatures: List[int], k: int) -> List[int]:
    """
    Finds the maximum temperature in every contiguous window of size k.
    
    Uses a monotonic decreasing deque storing INDICES.
    The front of the deque always holds the index of the current window's maximum.
    """
    if not temperatures or k <= 0:
        return []
    
    dq = deque()   # stores indices, values are in decreasing order
    result = []
    
    for i, temp in enumerate(temperatures):
        # Remove indices that are out of the current window (from the front)
        if dq and dq[0] <= i - k:
            dq.popleft()
        
        # Remove indices whose temperature is smaller than the current one
        # (they can never be the max while temp is still in range)
        while dq and temperatures[dq[-1]] < temp:
            dq.pop()
        
        dq.append(i)
        
        # Once we've processed at least k elements, record the window's max
        if i >= k - 1:
            result.append(temperatures[dq[0]])
    
    return result


# ---- Local testing block ----
if __name__ == "__main__":
    temperatures = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print(highest_temperature_in_window(temperatures, k))
    # Output: [3, 3, 5, 5, 6, 7]