# Highest Temperature in Every Time Window

from collections import deque

def max_temperatures(temperatures, k):
    dq = deque()
    result = []

    for i in range(len(temperatures)):
        while dq and dq[0] <= i - k:
            dq.popleft()

        while dq and temperatures[dq[-1]] <= temperatures[i]:
            dq.pop()

        dq.append(i)

        if i >= k - 1:
            result.append(temperatures[dq[0]])

    return result


temperatures = list(map(int, input("Enter temperatures separated by spaces: ").split()))
k = int(input("Enter window size k: "))

print("Maximum temperatures:", max_temperatures(temperatures, k))