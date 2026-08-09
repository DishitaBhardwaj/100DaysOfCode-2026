from collections import deque
from typing import List

class Solution:
    def maxSlidingWindow(self, temperatures: List[int], k: int) -> List[int]:
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
