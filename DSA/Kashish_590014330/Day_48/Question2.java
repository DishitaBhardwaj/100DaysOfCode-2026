import java.util.Arrays;

class Solution {
    public int[] solve(int n, int[] b) {

        Arrays.sort(b);

        int[] ans = new int[n];

        int index = 0;
        int pos = 0;

        for (int i = 0; i < n - 1; i++) {
            ans[i] = b[pos];
            pos += (n - i - 1);
        }

        ans[n - 1] = 1000000000;

        return ans;
    }
}
