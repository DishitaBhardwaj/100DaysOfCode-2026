def kth_smallest(A, B, k):
    # Always binary search on the smaller array
    if len(A) > len(B):
        A, B = B, A

    n, m = len(A), len(B)

    left = max(0, k - m)
    right = min(k, n)

    while left <= right:
        cutA = (left + right) // 2
        cutB = k - cutA

        leftA = float('-inf') if cutA == 0 else A[cutA - 1]
        rightA = float('inf') if cutA == n else A[cutA]

        leftB = float('-inf') if cutB == 0 else B[cutB - 1]
        rightB = float('inf') if cutB == m else B[cutB]

        if leftA <= rightB and leftB <= rightA:
            return max(leftA, leftB)

        elif leftA > rightB:
            right = cutA - 1
        else:
            left = cutA + 1

    return -1


# Input
A = list(map(int, input("Enter first sorted array: ").split()))
B = list(map(int, input("Enter second sorted array: ").split()))
k = int(input("Enter k: "))

# Output
print("K-th smallest element:", kth_smallest(A, B, k))