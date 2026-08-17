package DSA.TanmaySharma_590011578.Day_46;

import java.util.*;

public class Question2 {

    static long maximumPrefixDifferenceScore(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        long score = 0;

        int min = arr[0];
        int max = arr[n - 1];

        for (int i = 1; i < n; i++) {
            score += max - min;
        }

        return score;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5};

        long result = maximumPrefixDifferenceScore(arr);

        System.out.println(result);
    }
}