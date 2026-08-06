# Problem 2 
# Username Registration System

n = int(input("Enter the number of registration requests: "))
users = {}
print("Enter the usernames:")

for i in range(n):
    username = input()
    if username not in users:
        print("OK")
        users[username] = 1
    else:
        new_username = username + str(users[username])
        while new_username in users:
            users[username] = users[username] + 1
            new_username = username + str(users[username])
        print(new_username)
        users[new_username] = 1
        users[username] = users[username] + 1