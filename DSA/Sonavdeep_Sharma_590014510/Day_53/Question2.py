log = input().strip()
pattern = input().strip()

m, n = len(pattern), len(log)

if m > n:
    print([])
else:
    p = [0] * 26
    w = [0] * 26

    for ch in pattern:
        p[ord(ch) - ord('a')] += 1

    for i in range(m):
        w[ord(log[i]) - ord('a')] += 1

    ans = []

    if p == w:
        ans.append(0)

    for i in range(m, n):
        w[ord(log[i]) - ord('a')] += 1
        w[ord(log[i - m]) - ord('a')] -= 1

        if p == w:
            ans.append(i - m + 1)

    print(ans)