#Write an efficient function to rearrange an array to maximize the sum of (running max − running min) across all prefixes.
#Input: [7, 6, 5]. Output: 4.
def maximize_prefix_range(arr):
    arr = sorted(arr)
    perm = [arr[0]] + arr[1:-1] + [arr[-1]]
    mn = mx = perm[0]
    score = 0
    for x in perm:
        mn = min(mn, x)
        mx = max(mx, x)
        score += mx - mn
    return perm, score

arr = list(map(int, input("Enter array elements: ").split()))
perm, score = maximize_prefix_range(arr)
print("Rearranged array:", perm)
print("Maximum score:", score)