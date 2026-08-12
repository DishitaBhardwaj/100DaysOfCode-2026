import java.util.*;

class Solution {
    public long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;
        
        // Pair (beauty, length) and sort by beauty descending
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> beauty[b] - beauty[a]);
        
        // Min-heap of lengths, keeps k largest lengths seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumLength = 0;
        long maxPleasure = 0;
        
        for (int i : idx) {
            int currLen = length[i];
            int currBeauty = beauty[i];
            
            // Add current song's length
            minHeap.offer(currLen);
            sumLength += currLen;
            
            // If we exceed k songs, remove the smallest length
            if (minHeap.size() > k) {
                sumLength -= minHeap.poll();
            }
            
            // Current song has the minimum beauty among all considered so far
            // (only valid once we've included it, min beauty = currBeauty)
            maxPleasure = Math.max(maxPleasure, sumLength * currBeauty);
        }
        
        return maxPleasure;
    }
}
