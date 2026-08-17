import java.util.Arrays;

public class Q2 {

    public static int[] reconstruct(int n, int[] b) {
        Arrays.sort(b);
        
        int[] a = new int[n];
        int bIndex = 0;
        
        for (int i = 0; i < n - 1; i++) {
            a[i] = b[bIndex];
            bIndex += n - 1 - i;
        }
        
        a[n - 1] = b[b.length - 1];
        
        return a;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] b = {4, 2, 2};
        System.out.println("Output: " + Arrays.toString(reconstruct(n, b)));
    }
}