package DSA.Saransh_590024524.Day37;
import java.util.*;

class Solution {
    public int printerQueue(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }
        int time = 0;
        while (!q.isEmpty()) {
            int[] current = q.remove();
            boolean higher = false;
            for (int[] doc : q) {
                if (doc[0] > current[0]) {
                    higher = true;
                    break;
                }
            }
            if (higher) {
                q.add(current);
            } else {
                time++;
                if (current[1] == location) {
                    return time;
                }
            }
        }
        return time;
    }
}