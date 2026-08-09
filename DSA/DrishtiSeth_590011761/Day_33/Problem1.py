s = input()

depth = 0
ans = ""

for ch in s:
    if ch == '(':
        if depth > 0:
            ans += ch
        depth += 1
    else:
        depth -= 1
        if depth > 0:
            ans += ch

print(ans)
