def max_pair_sum(arr):
    arr.sort()
    total = 0
    for i in range(0, len(arr), 2):
        total += arr[i]
    return total

print("Enter the number of pairs:")
n = int(input())

print(f"Enter {2 * n} integers separated by spaces:")
arr = list(map(int, input().split()))

if len(arr) == 2 * n:
    print("Maximum pair sum is:", max_pair_sum(arr))
else:
    print(f"Invalid input. Please enter exactly {2 * n} integers.")
