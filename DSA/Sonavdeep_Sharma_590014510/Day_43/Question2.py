n = int(input())
arr = list(map(int, input().split()))

arr.sort()

sum_min = 0
for i in range(0, n, 2):
    sum_min += arr[i]

print(sum_min)