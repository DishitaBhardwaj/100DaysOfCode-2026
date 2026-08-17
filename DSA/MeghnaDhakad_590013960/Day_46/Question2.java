public class Main {

    static long maxPrefixDifferenceScore(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int min = arr[0];
        int max = arr[0];

        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        return (long) (arr.length - 1) * (max - min);
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5};

        System.out.println(maxPrefixDifferenceScore(arr));
    }
}