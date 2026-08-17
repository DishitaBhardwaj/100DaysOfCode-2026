n = int(input())
length = list(map(int, input().split()))
beauty = list(map(int, input().split()))
k = int(input())

songs = list(zip(length, beauty))
songs.sort(key=lambda x: x[1], reverse=True)

total = 0
ans = 0

for i in range(min(k, n)):
    total += songs[i][0]
    ans = max(ans, total * songs[i][1])

print(ans)