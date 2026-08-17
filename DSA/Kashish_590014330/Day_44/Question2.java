public class Question2 {

    public static String solveWithBubbleSort(int[] nums, int favoriteIndex, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int favValue = nums[favoriteIndex - 1];
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == favValue) {
                if (firstOccurrence == -1) {
                    firstOccurrence = i;
                }
                lastOccurrence = i;
            }
        }

        if (lastOccurrence < k) {
            return "YES";   
        } else if (firstOccurrence >= k) {
            return "NO";    
        } else {
            return "MAYBE"; 
        }
    }

}
