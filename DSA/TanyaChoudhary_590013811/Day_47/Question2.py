def kthSmallest(arr1, arr2, k):
    left = 0
    right = 0
    count = 0
    
    while left < len(arr1) and right < len(arr2):
        if arr1[left] <= arr2[right]:
            count += 1
            if count == k:
                return arr1[left]
            left += 1
        else:
            count += 1
            if count == k:
                return arr2[right]
            right += 1
    
    while left < len(arr1):
        count += 1
        if count == k:
            return arr1[left]
        left += 1
    
    while right < len(arr2):
        count += 1
        if count == k:
            return arr2[right]
        right += 1