package Day_48;

import java.util.Arrays;

public class Question2 {
    public int[] constructArray(int n, int[] b) {

        Arrays.sort(b);
        int[] ans = new int[n];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = b[index];
            index += (n - i - 1);
        }
        ans[n - 1] = 1000000000;

        return ans;
}
}