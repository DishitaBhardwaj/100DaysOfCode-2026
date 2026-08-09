public class Question2 {
    public static void main(String[] args) {
        int[] temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = temperatures.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = temperatures[i];
            for (int j = i; j < i + k; j++) {

                if (temperatures[j] > max) {
                    max = temperatures[j];
                }
            }
            result[i] = max;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}