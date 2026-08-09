n = int(input())
arr = list(map(int, input().split()))

arr.sort()

new = [arr[-1], arr[0]]
for i in range(1, n - 1):
    new.append(arr[i])

mx = new[0]
mn = new[0]
score = 0

for x in new:
    if x > mx:
        mx = x
    if x < mn:
        mn = x
    score += mx - mn

print(score)