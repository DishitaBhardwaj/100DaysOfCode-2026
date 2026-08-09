def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    i = j = 0

    # Iterating using range removes the forbidden while loop and avoids recursion limits
    for k in range(left, right + 1):
        if i < len(left_part) and (j >= len(right_part) or left_part[i] <= right_part[j]):
            arr[k] = left_part[i]
            i += 1
        else:
            arr[k] = right_part[j]
            j += 1

def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def binary_search(arr, target):
    def search(low, high):
        if low > high:
            return -1
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            return search(mid + 1, high)
        else:
            return search(low, mid - 1)

    return search(0, len(arr) - 1)

# Test run
incidents = [34, 7, 23, 32, 5, 62, 15]
merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23))