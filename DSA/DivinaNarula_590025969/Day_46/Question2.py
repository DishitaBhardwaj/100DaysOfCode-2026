# Maximum Prefix Difference Score

def maximum_prefix_difference_score(arr):
    arr.sort()

    result = [arr[0], arr[-1]]
    left = 1
    right = len(arr) - 2

    while left <= right:
        result.append(arr[left])
        left += 1
        if left <= right:
            result.append(arr[right])
            right -= 1

    current_min = result[0]
    current_max = result[0]
    score = 0

    for num in result:
        current_min = min(current_min, num)
        current_max = max(current_max, num)
        score += current_max - current_min

    return score


arr = list(map(int, input("Enter array elements: ").split()))
print(maximum_prefix_difference_score(arr))