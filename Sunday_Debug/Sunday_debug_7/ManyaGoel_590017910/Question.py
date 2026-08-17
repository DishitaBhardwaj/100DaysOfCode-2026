def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    i = j = 0
    k = left   
    # FIX: Use for loop to merge elements without the forbidden loop construct
    for k in range(left, right + 1):
        if i < len(left_part) and j < len(right_part):

            # FIX: Use <= to place smaller elements first for ascending order
            if left_part[i] <= right_part[j]:
                arr[k] = left_part[i]
                i += 1
            else:
                # FIX: Use right_part[j] because j tracks the right array
                arr[k] = right_part[j]
                j += 1

        elif i < len(left_part):
            # FIX: Copy any remaining elements from the left array
            arr[k] = left_part[i]
            i += 1

        else:
            # FIX: Copy from right_part instead of the incorrect left_part
            arr[k] = right_part[j]
            j += 1


def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2

        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def binary_search(arr, target, low=0, high=None):
    if high is None:
        high = len(arr) - 1

    # FIX: Return -1 when the target is not present
    if low > high:
        return -1

    mid = (low + high) // 2

    if arr[mid] == target:
        return mid

    # FIX: Use recursion to search the correct half
    if arr[mid] < target:
        return binary_search(arr, target, mid + 1, high)

    # FIX: Search before mid when the target is smaller
    return binary_search(arr, target, low, mid - 1)

incidents = [34, 7, 23, 32, 5, 62, 15]
merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23))