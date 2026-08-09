def merge(arr, left, mid, right):
    left_part  = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    i = j = 0
    
    # Replaced the forbidden while loops with a single bounded for loop
    for k in range(left, right + 1):
        if i < len(left_part) and j < len(right_part):
            if left_part[i] <= right_part[j]:  # Fixed: Sort ascending 
                arr[k] = left_part[i]
                i += 1
            else:
                arr[k] = right_part[j]         # Fixed: Used correct index 'j'
                j += 1
        elif i < len(left_part):
            arr[k] = left_part[i]
            i += 1
        elif j < len(right_part):
            arr[k] = right_part[j]             # Fixed: Used correct array and index
            j += 1

def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid) 
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def binary_search(arr, target):
    # Replaced the forbidden while loop with a recursive helper function
    def search_recursive(low, high):
        if low > high:
            return -1
            
        mid = (low + high) // 2                # Fixed: Removed the +1 bias
        
        if arr[mid] == target: 
            return mid
        elif arr[mid] < target: 
            return search_recursive(mid + 1, high)
        else: 
            return search_recursive(low, mid - 1)  # Fixed: Should be mid - 1, not mid
            
    return search_recursive(0, len(arr) - 1)

# --- Test Execution ---
incidents = [34, 7, 23, 32, 5, 62, 15]
merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23))