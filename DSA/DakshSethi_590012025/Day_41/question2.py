from collections import deque

class Solution:
    def predictPartyVictory(self, jobs: str) -> str:
        sales = deque()
        marketing = deque()
        n = len(jobs)

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