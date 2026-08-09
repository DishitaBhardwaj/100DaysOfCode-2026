#Write an efficient function to find the k-th smallest element across two sorted arrays without merging them.
#Input: A = [2, 3, 6, 7], B = [1, 4, 5, 8], k = 5. Output: 5.
def kth_smallest(A, B, k):  
    if len(A) > len(B):
        return kth_smallest(B, A, k)
    n, m = len(A), len(B)
    if k < 1 or k > n + m:
        return "Invalid k"
    low = max(0, k - m)
    high = min(k, n)
    while low <= high:
        cutA = (low + high) // 2
        cutB = k - cutA
        leftA = float('-inf') if cutA == 0 else A[cutA - 1]
        leftB = float('-inf') if cutB == 0 else B[cutB - 1]
        rightA = float('inf') if cutA == n else A[cutA]
        rightB = float('inf') if cutB == m else B[cutB]
        if leftA <= rightB and leftB <= rightA:
            return max(leftA, leftB)
        elif leftA > rightB:
            high = cutA - 1
        else:
            low = cutA + 1

A = list(map(int, input("Enter sorted elements of Array A: ").split()))
B = list(map(int, input("Enter sorted elements of Array B: ").split()))
k = int(input("Enter k: "))
result = kth_smallest(A, B, k)
print("K-th smallest element:", result)