import java.util.PriorityQueue;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[k], a[k]));
        
        for (int i = 0; i < m; i++) {
            maxHeap.offer(score[i]);
        }
        
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}

/*
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }
}
*/