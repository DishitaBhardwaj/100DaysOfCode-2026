def merge_count(arr, left, mid, right):
    temp = []
    i = left
    j = mid + 1
    inv = 0

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            inv += (mid - i + 1)
            j += 1

    while i <= mid:
        temp.append(arr[i])
        i += 1

    while j <= right:
        temp.append(arr[j])
        j += 1

    arr[left:right + 1] = temp
    return inv

def count_inversions(arr, left, right):
    inv = 0
    if left < right:
        mid = (left + right) // 2
        inv += count_inversions(arr, left, mid)
        inv += count_inversions(arr, mid + 1, right)
        inv += merge_count(arr, left, mid, right)
    return inv

arr = list(map(int, input("Enter the array elements: ").split()))
result = count_inversions(arr, 0, len(arr) - 1)
print("Number of inversions:", result)
