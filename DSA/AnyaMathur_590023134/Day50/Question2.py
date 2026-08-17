# Problem 2 
# The Quarry Smasher 

def LastRemainingRock(rocks):
    while len(rocks) > 1:
        rocks.sort()
        first = rocks.pop()
        second = rocks.pop()
        if first != second:
            rocks.append(first - second)
    if len(rocks) == 0:
        return 0
    return rocks[0]

rocks = list(map(int, input("Enter the rock weights: ").split()))
print("Last remaining rock weight:", LastRemainingRock(rocks))