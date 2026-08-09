from collections import deque
jobs = input("Enter the jobs (S for Sales, M for Marketing): ")
queue = deque(jobs)

sales = jobs.count('S')
marketing = jobs.count('M')

ban_sales = 0
ban_marketing = 0

while sales > 0 and marketing > 0:
    job = queue.popleft()

    if job == 'S':
        if ban_sales > 0:
            ban_sales -= 1
            sales -= 1
        else:
            ban_marketing += 1
            queue.append('S')

    else:  
        if ban_marketing > 0:
            ban_marketing -= 1
            marketing -= 1
        else:
            ban_sales += 1
            queue.append('M')

if sales > 0:
    print("Sales")
else:
    print("Marketing")