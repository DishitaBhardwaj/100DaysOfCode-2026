import java.util.*;
public class Question2 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum=0;
        for( int i=0 ; i<nums.length;i+=2){
            maxSum+=nums[i];

        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        if (n % 2 != 0) {
            System.out.println("Array size must be even.");
            sc.close();
            return;
        }
        int[] nums = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Maximum Sum = " + arrayPairSum(nums));
        sc.close();
    }
}