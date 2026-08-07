log = input("Enter log: ")
pattern = input("Enter pattern: ")
n = len(log)
m = len(pattern)
pat = [0] * 26
for ch in pattern:
    pat[ord(ch) - ord('a')] += 1
ans = []
for i in range(n - m + 1):
    h = [0] * 26
    for j in range(i, i + m):
        h[ord(log[j]) - ord('a')] += 1
    if h == pat:
        ans.append(i)
print(ans)