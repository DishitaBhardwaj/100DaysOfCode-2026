class Solution:
    def inversionCount(self, arr):
        def mergeSort(arr):
            if len(arr) <= 1:
                return arr, 0

            mid = len(arr) // 2
            left, inv_left = mergeSort(arr[:mid])
            right, inv_right = mergeSort(arr[mid:])

            merged = []
            i = j = 0
            inv_count = inv_left + inv_right

            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    merged.append(left[i])
                    i += 1
                else:
                    merged.append(right[j])
                    inv_count += len(left) - i
                    j += 1

            merged.extend(left[i:])
            merged.extend(right[j:])

            return merged, inv_count

        return mergeSort(arr)[1]


# For VS Code testing
if __name__ == "__main__":
    arr = [2, 4, 1, 3, 5]
    sol = Solution()
    print(sol.inversionCount(arr))