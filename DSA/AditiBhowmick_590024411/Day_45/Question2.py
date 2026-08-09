def merge(arr, temp, left, mid, right):
    i = left
    j = mid + 1
    k = left
    inv_count = 0

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp[k] = arr[i]
            i += 1
        else:
            temp[k] = arr[j]
            inv_count += (mid - i + 1)
            j += 1
        k += 1

    while i <= mid:
        temp[k] = arr[i]
        i += 1
        k += 1

    while j <= right:
        temp[k] = arr[j]
        j += 1
        k += 1

    for x in range(left, right + 1):
        arr[x] = temp[x]

    return inv_count

def merge_sort(arr, temp, left, right):
    inv_count = 0

    if left < right:
        mid = (left + right) // 2

        inv_count += merge_sort(arr, temp, left, mid)
        inv_count += merge_sort(arr, temp, mid + 1, right)
        inv_count += merge(arr, temp, left, mid, right)

    return inv_count 
arr = list(map(int, input("Enter the array elements: ").split()))

temp = [0] * len(arr)
result = merge_sort(arr, temp, 0, len(arr) - 1)

print("Number of inversions:", result)