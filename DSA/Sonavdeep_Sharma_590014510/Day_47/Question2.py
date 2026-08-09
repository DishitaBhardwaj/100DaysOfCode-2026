def kthSmallest(A, B, k):
    i = 0
    j = 0
    count = 0

    while i < len(A) and j < len(B):
        if A[i] < B[j]:
            count += 1
            if count == k:
                return A[i]
            i += 1
        else:
            count += 1
            if count == k:
                return B[j]
            j += 1

    while i < len(A):
        count += 1
        if count == k:
            return A[i]
        i += 1

    while j < len(B):
        count += 1
        if count == k:
            return B[j]
        j += 1