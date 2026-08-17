from collections import deque

def maxTemperature(temps, k):
    deq = deque()
    result = []
    
    for i in range(len(temps)):
        if deq and deq[0] < i - k + 1:
            deq.popleft()
        
        while deq and temps[deq[-1]] <= temps[i]:
            deq.pop()
        
        deq.append(i)
        
        if i >= k - 1:
            result.append(temps[deq[0]])
    
    return result

print(maxTemperature([4, 3, 5, 4, 3, 3, 6, 7], 3))
print(maxTemperature([1, 3, -1, -3, 5, 3, 6, 7], 3))