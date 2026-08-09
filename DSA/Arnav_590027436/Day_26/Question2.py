def check_target(arr):
    arr.sort()
    for i in range(len(arr)):
        left = 0
        right = len(arr) - 1
        c = arr[i]
        
        while left < right:
            if left == i:
                left += 1
                continue
            if right == i:
                right -= 1
                continue
            
            current_sum = arr[left] + arr[right]
        
            if current_sum == c:
                return True
            elif current_sum < c:
                left += 1
            else:
                right -= 1
            
    return False