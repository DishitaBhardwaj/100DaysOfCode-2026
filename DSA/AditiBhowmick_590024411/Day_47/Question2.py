def kth_smallest(A, B, k):
    i = j = 0

    while True:
        
        if i == len(A):
            return B[j + k - 1]

        if j == len(B):
            return A[i + k - 1]

        if k == 1:
            return min(A[i], B[j])

        step = k // 2
        new_i = min(i + step, len(A)) - 1
        new_j = min(j + step, len(B)) - 1

        if A[new_i] <= B[new_j]:
            k -= (new_i - i + 1)
            i = new_i + 1
        else:
            k -= (new_j - j + 1)
            j = new_j + 1

A = list(map(int, input("Enter elements of first sorted array: ").split()))
B = list(map(int, input("Enter elements of second sorted array: ").split()))
k = int(input("Enter k: "))

print("k-th smallest element:", kth_smallest(A, B, k))