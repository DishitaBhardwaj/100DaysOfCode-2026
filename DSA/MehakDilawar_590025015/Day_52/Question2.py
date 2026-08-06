#Write an efficient function that processes a list of username registration requests, returning "OK" if a username is available, 
#or otherwise appending the smallest positive integer that makes it unique and returning that new username.
#Input: ["abacaba", "acaba", "abacaba", "acab"]. Output: ["OK", "OK", "abacaba1", "OK"].
n = int(input())
requests = []
for _ in range(n):
    requests.append(input().strip())
registered = {}
result = []
for name in requests:
    if name not in registered:
        registered[name] = 1
        result.append("OK")
    else:
        new_name = name + str(registered[name])
        while new_name in registered:
            registered[name] += 1
            new_name = name + str(registered[name])
        result.append(new_name)
        registered[new_name] = 1
        registered[name] += 1
for ans in result:
    print(ans)