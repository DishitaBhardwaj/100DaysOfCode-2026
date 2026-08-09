#Write an efficient function to count the number of inversions in an integer array, where an inversion is a pair (i, j)
#with i < j and arr[i] > arr[j].
#Input: [2, 4, 1, 3, 5]. Output: 3.
def count_inversions(arr):
    def merge_sort(left, right):
        if left >= right:
            return 0
        mid = (left + right) // 2
        inv_count = merge_sort(left, mid)
        inv_count += merge_sort(mid + 1, right)
        temp = []
        i, j = left, mid + 1
        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                inv_count += (mid - i + 1)
                j += 1
        while i <= mid:
            temp.append(arr[i])
            i += 1
        while j <= right:
            temp.append(arr[j])
            j += 1
        arr[left:right + 1] = temp
        return inv_count
    return merge_sort(0, len(arr) - 1)

arr = list(map(int, input("Enter the array elements separated by spaces: ").split()))
print("Number of inversions:", count_inversions(arr))
