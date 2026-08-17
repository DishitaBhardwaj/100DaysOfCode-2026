def maximize_prefix_difference(arr):
    arr.sort()

    rearranged = []
    left = 0
    right = len(arr) - 1

    # Rearrange: largest, smallest, largest, smallest...
    while left <= right:
        if left != right:
            rearranged.append(arr[right])
            rearranged.append(arr[left])
        else:
            rearranged.append(arr[left])
        left += 1
        right -= 1

    running_max = rearranged[0]
    running_min = rearranged[0]
    score = 0

    for num in rearranged:
        running_max = max(running_max, num)
        running_min = min(running_min, num)
        score += running_max - running_min

    return score


# Input
arr = list(map(int, input("Enter the array: ").split()))

# Output
print("Maximum Prefix Difference Score:", maximize_prefix_difference(arr))