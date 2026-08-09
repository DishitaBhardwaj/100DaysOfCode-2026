n = int(input("Enter n: "))
b = list(map(int, input("Enter elements of b: ").split()))

a = [0] * n

for i in range(n - 1):
    a[i] = b[i]

a[n - 1] = 100

print("Reconstructed array:", a)