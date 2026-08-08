from collections import Counter

n = int(input())
teams = [input().strip() for _ in range(n)]

freq = Counter(teams)

winner = max(freq, key=freq.get)
print(winner)