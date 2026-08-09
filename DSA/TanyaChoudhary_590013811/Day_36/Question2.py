from collections import deque

def ticketCounter(n, k):
    queue = deque(range(1, n + 1))
    minute = 0
    
    while queue:
        person = queue.popleft()
        minute += 1
        
        if person % 2 != 0:
            queue.append(person)
        
        if person == k and person % 2 == 0:
            return minute
    
    return minute

print(ticketCounter(4, 3))
print(ticketCounter(5, 2))