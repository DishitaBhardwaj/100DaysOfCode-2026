def max_prefix_difference(arr):
    arr.sort()  

    left, right = 0, len(arr) - 1
    rearranged = []

    while left <= right:
        if left == right:
            rearranged.append(arr[left])
        else:
            rearranged.append(arr[left])
            rearranged.append(arr[right])
        left += 1
        right -= 1

    running_min = rearranged[0]
    running_max = rearranged[0]
    total = 0

    for x in rearranged:
        running_min = min(running_min, x)
        running_max = max(running_max, x)
        total += (running_max - running_min)

    return total

arr = list(map(int, input("Enter array elements: ").split()))
print("Maximum sum:", max_prefix_difference(arr))