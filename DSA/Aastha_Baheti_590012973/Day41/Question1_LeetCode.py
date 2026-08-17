from collections import deque

def officePrinterWars(jobs):
    n = len(jobs)

    sales = deque()
    marketing = deque()

    for i, ch in enumerate(jobs):
        if ch == 'S':
            sales.append(i)
        else:
            marketing.append(i)

    while sales and marketing:
        s = sales.popleft()
        m = marketing.popleft()

        if s < m:
            sales.append(s + n)
        else:
            marketing.append(m + n)

    return "Sales" if sales else "Marketing"


# Example Usage
jobs = input().strip()
print(officePrinterWars(jobs))