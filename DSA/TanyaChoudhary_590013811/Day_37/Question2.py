from collections import deque

def printerQueue(priorities, pos):
    queue = deque()
    
    for i in range(len(priorities)):
        queue.append((priorities[i], i))
    
    minute = 0
    
    while queue:
        current = queue.popleft()
        
        if any(current[0] < item[0] for item in queue):
            queue.append(current)
        else:
            minute += 1
            if current[1] == pos:
                return minute
    
    return minute