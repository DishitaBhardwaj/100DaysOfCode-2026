def reconstruct_array(n, b):
    b.sort()

    a = []
    idx = 0

    # Reconstruct first n-1 elements
    for i in range(n - 1):
        a.append(b[idx])
        idx += (n - i - 1)

    # Last element can be any value greater than all others
    a.append(100)

    return a


# Input
n = int(input("Enter n: "))
b = list(map(int, input("Enter array b: ").split()))

# Output
print("Reconstructed array:", reconstruct_array(n, b))