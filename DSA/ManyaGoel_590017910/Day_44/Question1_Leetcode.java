public class Question1_Leetcode {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;

        int min= arr[0], max = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int range = max - min;
        if (range % (n - 1) != 0) return false; 
        int d = range / (n - 1);

        if (d == 0) {
            for (int num : arr) {
                if (num != min) return false;
            }
            return true;
        }

        for (int i = 0; i < n; i++) {
            while (arr[i] != min + i * d) {
                int index = (arr[i] - min) / d;
                if ((arr[i] - min) % d != 0  || index < 0 ||index >= n  || arr[index] == arr[i]) {
                    return false;
                }
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return true;
    }
}