# Count Inversions in an Array

def merge_sort(arr):
    if len(arr) <= 1:
        return arr, 0

    mid = len(arr) // 2

    left, left_count = merge_sort(arr[:mid])
    right, right_count = merge_sort(arr[mid:])

    merged = []
    i = j = 0
    count = left_count + right_count

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            count += len(left) - i
            j += 1

    merged.extend(left[i:])
    merged.extend(right[j:])

    return merged, count


arr = list(map(int, input("Enter array elements: ").split()))

_, inversions = merge_sort(arr)

print(inversions)