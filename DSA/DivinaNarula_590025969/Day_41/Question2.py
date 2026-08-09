# Office Printer Wars

from collections import deque

jobs = input("Enter jobs: ").strip()

sales = deque()
marketing = deque()

for i, job in enumerate(jobs):
    if job == 'S':
        sales.append(i)
    else:
        marketing.append(i)

n = len(jobs)

while sales and marketing:
    s = sales.popleft()
    m = marketing.popleft()

    if s < m:
        sales.append(s + n)
    else:
        marketing.append(m + n)

if sales:
    print("Sales")
else:
    print("Marketing")