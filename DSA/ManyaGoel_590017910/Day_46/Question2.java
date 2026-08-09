import java.util.*;

public class Question2 {
    public static long maxPrefixDifferenceScore(int[] nums) {
        int n = nums.length;
        int min = nums[0], max = nums[0];
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }        
        return (long) (n - 1) * (max - min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Array: "+ Arrays.toString(nums));
        long score = maxPrefixDifferenceScore(nums);     
        System.out.println("Maximum possible score: " + score);      
        sc.close();
    }
}