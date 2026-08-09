rocks = [2, 7, 4, 1, 8, 1]

while len(rocks) > 1:
    rocks.sort()

    a = rocks.pop()      # largest
    b = rocks.pop()      # second largest

    if a != b:
        rocks.append(a - b)

if len(rocks) == 1:
    print(rocks[0])
else:
    print(0)