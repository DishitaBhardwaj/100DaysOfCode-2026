n = int(input())

mp = {}
ans = -1

for i in range(n):
    vendor, lot, cert = input().split()
    key = (vendor, lot)

    if key not in mp:
        mp[key] = cert
    elif mp[key] != cert and ans == -1:
        ans = i

print(ans)