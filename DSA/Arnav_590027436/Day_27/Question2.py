def numSubarrayBoundedMax(arr, l, r):
    def count_at_most(x):
        total_count = 0
        current_segment_len = 0
        
        for val in arr:
            if val <= x:
                current_segment_len += 1
                total_count += current_segment_len
            else:
                current_segment_len = 0
                
        return total_count

    return count_at_most(r) - count_at_most(l - 1)