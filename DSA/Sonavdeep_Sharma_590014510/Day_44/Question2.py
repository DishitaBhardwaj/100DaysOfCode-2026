t = int(input())

for _ in range(t):
    n, f, k = map(int, input().split())
    nums = list(map(int, input().split()))

    fav = nums[f - 1]

    greater = 0
    equal = 0

    for x in nums:
        if x > fav:
            greater += 1
        elif x == fav:
            equal += 1

    if greater >= k:
        print("NO")
    elif greater + equal <= k:
        print("YES")
    else:
        print("MAYBE")