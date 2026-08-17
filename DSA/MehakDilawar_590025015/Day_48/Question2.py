#Write an efficient function to reconstruct any valid array a of length n from array b, which contains min(a[i], a[j]) for every pair i < j.
#Input: n = 3, b = [4, 2, 2]. Output: [2, 4, 100].
def reconstruct_array(n, b):
    a = [0] * n
    idx = 0
    for i in range(n - 1):
        a[i] = b[idx]
        idx += (n - 1 - i)
    a[-1] = 10**9  
    return a

n = int(input())
b = list(map(int, input().split()))
result = reconstruct_array(n, b)
print(*result)