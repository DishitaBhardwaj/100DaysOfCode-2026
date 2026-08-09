from collections import deque

def officePrinterWars(dept1, dept2):
    queue1 = deque(dept1)
    queue2 = deque(dept2)
    
    while queue1 and queue2:
        job1 = queue1.popleft()
        job2 = queue2.popleft()
        
        if job1 > job2:
            queue1.append(job1)
            queue1.append(job2)
        elif job2 > job1:
            queue2.append(job2)
            queue2.append(job1)
        else:
            queue1.append(job1)
            queue2.append(job2)
    
    if queue1:
        return f"Department 1 wins with jobs: {list(queue1)}"
    elif queue2:
        return f"Department 2 wins with jobs: {list(queue2)}"
    else:
        return "Draw!"

print(officePrinterWars([3, 5, 2], [4, 1, 6]))
print(officePrinterWars([1, 2, 3], [4, 5, 6]))
print(officePrinterWars([5, 5], [5, 5]))