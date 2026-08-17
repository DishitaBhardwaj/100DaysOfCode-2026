import java.util.Arrays;

public class Solution {

    public static int[] constructArray(int n, int[] b) {
        Arrays.sort(b);

        int[] a = new int[n];
        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - i - 1);
        }

        // Last element can be any value >= previous element
        a[n - 1] = 1000000000;

        return a;
    }

    public static void main(String[] args) {
        int[] ans1 = constructArray(2, new int[]{5});
        System.out.println(Arrays.toString(ans1));

        int[] ans2 = constructArray(3, new int[]{4, 2, 2});
        System.out.println(Arrays.toString(ans2));
    }
}
