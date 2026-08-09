import java.util.*;

class Question2 {
    public int[] reconstructArray(int n, int[] b) {
        Arrays.sort(b);

        int[] ans = new int[n];
        int idx = 0;
        int pos = 0;

        for (int cnt = n - 1; cnt >= 1; cnt--) {
            ans[idx++] = b[pos];
            pos += cnt;
        }

        ans[idx] = 1000000000; 
        return ans;
    }
}