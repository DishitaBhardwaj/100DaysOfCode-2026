from collections import deque

def office_printer_wars(jobs):
    n = len(jobs)
    sales = deque()
    marketing = deque()

    # Store indices of each department's jobs
    for i, ch in enumerate(jobs):
        if ch == 'S':
            sales.append(i)
        else:  # 'M'
            marketing.append(i)

    while sales and marketing:
        s = sales.popleft()
        m = marketing.popleft()

        if s < m:
            # Sales eliminates Marketing
            sales.append(s + n)
        else:
            # Marketing eliminates Sales
            marketing.append(m + n)

    return "Sales" if sales else "Marketing"


# Input
jobs = input("Enter jobs string: ").strip().upper()

# Output
print(office_printer_wars(jobs))