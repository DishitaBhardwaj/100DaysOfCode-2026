from collections import deque

class Solution:
    def officePrinterWars(self, jobs: str) -> str:
        n = len(jobs)

        sales = deque()
        marketing = deque()

        for i, ch in enumerate(jobs):
            if ch == 'S':
                sales.append(i)
            else:   # 'M'
                marketing.append(i)

        while sales and marketing:
            s = sales.popleft()
            m = marketing.popleft()

            if s < m:
                sales.append(s + n)
            else:
                marketing.append(m + n)

        return "Sales" if sales else "Marketing"


# Example
sol = Solution()
print(sol.officePrinterWars("SMM"))   # Marketing
print(sol.officePrinterWars("SMSM"))  # Sales or Marketing depending on simulation