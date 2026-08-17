def merge_and_count(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]

    i = j = 0
    k = left
    inversions = 0

    while i < len(left_part) and j < len(right_part):
        if left_part[i] <= right_part[j]:
            arr[k] = left_part[i]
            i += 1
        else:
            arr[k] = right_part[j]
            inversions += len(left_part) - i
            j += 1
        k += 1

    while i < len(left_part):
        arr[k] = left_part[i]
        i += 1
        k += 1

    while j < len(right_part):
        arr[k] = right_part[j]
        j += 1
        k += 1

    return inversions


def merge_sort(arr, left, right):
    inversions = 0

    if left < right:
        mid = (left + right) // 2

        inversions += merge_sort(arr, left, mid)
        inversions += merge_sort(arr, mid + 1, right)
        inversions += merge_and_count(arr, left, mid, right)

    return inversions


# Input
arr = list(map(int, input("Enter the array: ").split()))

# Count inversions
count = merge_sort(arr, 0, len(arr) - 1)

# Output
print("Number of Inversions:", count)