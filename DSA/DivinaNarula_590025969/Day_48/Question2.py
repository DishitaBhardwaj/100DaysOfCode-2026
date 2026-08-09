# Assembly via Minimums

def reconstruct_array(n, b):
    b.sort()

    a = []
    index = 0

    for i in range(n - 1):
        a.append(b[index])
        index += n - i - 1

    a.append(100)

    return a


n = int(input("Enter n : "))
b = list(map(int, input("Enter b : ").split()))

result = reconstruct_array(n, b)

print(*result)