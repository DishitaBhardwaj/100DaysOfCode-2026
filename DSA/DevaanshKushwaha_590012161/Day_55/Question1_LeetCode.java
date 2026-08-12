import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        // index array
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        
        // sort indices by value descending
        Arrays.sort(idx, (a, b) -> nums[b] - nums[a]);
        
        // take first k indices (largest k values)
        int[] chosen = new int[k];
        for (int i = 0; i < k; i++) chosen[i] = idx[i];
        
        // sort chosen indices in ascending order to preserve original sequence order
        Arrays.sort(chosen);
        
        // build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[chosen[i]];
        }
        
        return result;
    }
}
