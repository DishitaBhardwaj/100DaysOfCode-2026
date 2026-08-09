import java.util.Arrays;

public class Assemble_Minimum {

    public static int[] reconstructArray(int n, int[] b) {
        Arrays.sort(b);

        int[] a = new int[n];

        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - i - 1);
        }

        // Last element can be any large value
        a[n - 1] = 1000000000;

        return a;
    }

    public static void main(String[] args) {

        int n = 3;
        int[] b = {4, 2, 2};

        int[] result = reconstructArray(n, b);

        System.out.println(Arrays.toString(result));
    }
    
}
