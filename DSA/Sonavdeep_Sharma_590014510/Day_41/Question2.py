from collections import deque

jobs = input().strip()

s = deque()
m = deque()
n = len(jobs)

for i, ch in enumerate(jobs):
    if ch == 'S':
        s.append(i)
    else:
        m.append(i)

while s and m:
    si = s.popleft()
    mi = m.popleft()

    if si < mi:
        s.append(si + n)
    else:
        m.append(mi + n)

if s:
    print("Sales")
else:
    print("Marketing")