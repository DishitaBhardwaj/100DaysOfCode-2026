# Username Registration System

n = int(input("Enter the number of username requests: "))

print("Enter the usernames:")
usernames = []
for i in range(n):
    usernames.append(input())

registered = {}

print("\nOutput:")
for name in usernames:
    if name not in registered:
        registered[name] = 1
        print("OK")
    else:
        new_name = name + str(registered[name])
        while new_name in registered:
            registered[name] += 1
            new_name = name + str(registered[name])

        print(new_name)
        registered[new_name] = 1
        registered[name] += 1