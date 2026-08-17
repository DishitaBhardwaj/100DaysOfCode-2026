#Given an array of hourly temperatures and window size k, find the maximum temperature in every contiguous window of size k.
#Input: temperatures = [1, 3, -1, -3, 5, 3, 6, 7], k = 3. Output: [3, 3, 5, 5, 6, 7]
from collections import deque
temperatures = list(map(int, input("Enter temperatures: ").split()))
k = int(input("Enter window size (k): "))
def max_window(temperatures, k):
    if not temperatures or k == 0:
        return []
    dq = deque()
    result = []
    for i in range(len(temperatures)):
        while dq and dq[0] <= i - k:
            dq.popleft()
        while dq and temperatures[dq[-1]] < temperatures[i]:
            dq.pop()
        dq.append(i)
        if i >= k - 1:
            result.append(temperatures[dq[0]])
    return result
print("Output:", max_window(temperatures, k))