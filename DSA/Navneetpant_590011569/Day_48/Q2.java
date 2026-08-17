import java.util.*;

class Solution {
    public int[] constructArray(int n, int[] b) {

        Arrays.sort(b);

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            ans[i] = b[index];
            index += (n - 1 - i);
        }

        ans[n - 1] = 1000000000;

        return ans;
    }
}