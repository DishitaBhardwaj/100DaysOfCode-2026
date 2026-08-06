def register_users(usernames):
    used = {}
    result = []

    for name in usernames:
        if name not in used:
            result.append("OK")
            used[name] = 1
        else:
            while f"{name}{used[name]}" in used:
                used[name] += 1

            new_name = f"{name}{used[name]}"
            result.append(new_name)

            used[new_name] = 1
            used[name] += 1

    return result

n = int(input("Enter number of usernames: "))
usernames = []

print("Enter usernames:")
for _ in range(n):
    usernames.append(input())

print(register_users(usernames))