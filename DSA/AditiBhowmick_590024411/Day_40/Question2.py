from collections import deque

temperatures = list(map(int, input("Enter the temperatures: ").split()))
k = int(input("Enter window size (k): "))

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

print("Maximum temperatures:", result)