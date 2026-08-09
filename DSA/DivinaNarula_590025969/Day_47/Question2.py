# K-th Smallest Element in Two Sorted Arrays

def kth_smallest(A, B, k):
    if len(A) > len(B):
        return kth_smallest(B, A, k)

    m = len(A)
    n = len(B)

    left = max(0, k - n)
    right = min(k, m)

    while left <= right:
        cutA = (left + right) // 2
        cutB = k - cutA

        leftA = float("-inf") if cutA == 0 else A[cutA - 1]
        rightA = float("inf") if cutA == m else A[cutA]

        leftB = float("-inf") if cutB == 0 else B[cutB - 1]
        rightB = float("inf") if cutB == n else B[cutB]

        if leftA <= rightB and leftB <= rightA:
            return max(leftA, leftB)
        elif leftA > rightB:
            right = cutA - 1
        else:
            left = cutA + 1


A = list(map(int, input("Enter first sorted array: ").split()))
B = list(map(int, input("Enter second sorted array: ").split()))
k = int(input("Enter k: "))

print(kth_smallest(A, B, k))