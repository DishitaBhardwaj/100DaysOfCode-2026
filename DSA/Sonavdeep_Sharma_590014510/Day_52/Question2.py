n = int(input())
used = {}

for _ in range(n):
    name = input().strip()

    if name not in used:
        print("OK")
        used[name] = 1
    else:
        new_name = name + str(used[name])
        while new_name in used:
            used[name] += 1
            new_name = name + str(used[name])

        print(new_name)
        used[new_name] = 1
        used[name] += 1