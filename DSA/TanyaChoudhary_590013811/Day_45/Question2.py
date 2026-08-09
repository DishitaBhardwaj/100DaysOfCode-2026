def count_inv(a):
    if len(a) < 2:
        return a, 0
    m = len(a) // 2
    l, x = count_inv(a[:m])
    r, y = count_inv(a[m:])
    i = j = z = 0
    res = []
    while i < len(l) and j < len(r):
        if l[i] <= r[j]:
            res.append(l[i]); i += 1
        else:
            res.append(r[j]); z += len(l) - i; j += 1
    return res + l[i:] + r[j:], x + y + z

arr = list(map(int, input().split()))
print(count_inv(arr)[1])