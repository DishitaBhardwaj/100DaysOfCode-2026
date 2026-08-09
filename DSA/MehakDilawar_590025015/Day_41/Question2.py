#Simulate a queue-based elimination game between two departments' print jobs to determine which department remains last.
#Input: jobs = "SMM". Output: "Marketing".
from collections import deque
jobs = input("Enter jobs (S/M): ").strip().upper()
sales = deque()
marketing = deque()
n = len(jobs)
for i, ch in enumerate(jobs):
    if ch == 'S':
        sales.append(i)
    elif ch == 'M':
        marketing.append(i)
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