package DSA.Saransh_590024524.Day39;

public class Question2 {
    
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int s = 0, e = 0;
        int rooms = 0, maxRooms = 0;
        while (s < n) {
            if (starts[s] < ends[e]) {
                rooms++;   
                maxRooms = Math.max(maxRooms, rooms);
                s++;
            } else {
                rooms--;                
                e++;
            }
        }
        return maxRooms;
    }
}