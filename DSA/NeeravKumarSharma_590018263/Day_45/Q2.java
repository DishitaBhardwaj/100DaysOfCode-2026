public class Q2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Output: " + countInversions(arr));
    }

    public static int countInversions(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int inversions = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            inversions += mergeSortAndCount(arr, temp, left, mid);
            
            inversions += mergeSortAndCount(arr, temp, mid + 1, right);
            
            inversions += mergeAndCount(arr, temp, left, mid, right);
        }
        
        return inversions;
    }

    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      
        int j = mid + 1;   
        int k = left;      
        int swaps = 0;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                swaps += (mid + 1 - i);
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        return swaps;
    }
}