# Problem 2
# The Security Scanner 

log = input("Enter log: ")
pattern = input("Enter pattern: ")
result = []
for i in range(len(log) - len(pattern) + 1):
    substring = log[i:i + len(pattern)]
    if sorted(substring) == sorted(pattern):
        result.append(i)
print(result)