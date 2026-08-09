t = int(input())

for _ in range(t):
    n = int(input())
    b = list(map(int, input().split()))

    b.sort()

    ans = []

    for i in range(n - 1):
        ans.append(b[i])

    ans.append(100)

    print(*ans)