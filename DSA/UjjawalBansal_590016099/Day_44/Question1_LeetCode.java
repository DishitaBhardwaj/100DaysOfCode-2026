import java.util.Arrays;

public class Question1_LeetCode {
    // Solution using sorting. O(NlogN) time
    public static boolean canMakeArithmeticProgressionSorting(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) return false;
        }
        return true;
    }

    // Optimized Solution. O(N) time
    public static boolean canMakeArithmeticProgressionOptimized(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        if (min == max) return true;
        
        if ((max - min) % (n - 1) != 0) return false;
        
        int diff = (max - min)/(n - 1);
        int i = 0;
        
        while (i < n) {
            if (arr[i] == min + i * diff) i++; 

            else if ((arr[i] - min) % diff != 0) return false;

            else {
                int id = (arr[i] - min) / diff;
                
                if (arr[i] == arr[id]) {
                    return false;
                }
                
                int temp = arr[i];
                arr[i] = arr[id];
                arr[id] = temp;
            }
        }
        return true;
    }
}
