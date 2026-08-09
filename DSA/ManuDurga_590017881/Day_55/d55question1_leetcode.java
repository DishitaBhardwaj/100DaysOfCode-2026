package Day_55;

import java.util.*;

public class d55question1_leetcode {
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int threshold = sorted[sorted.length - k];
        int count = 0;
        for (int i = sorted.length - k; i < sorted.length; i++) {
            if (sorted[i] == threshold) count++;
        }

        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length && j < k; i++) {
            if (nums[i] > threshold) {
                res[j++] = nums[i];
            } else if (nums[i] == threshold && count > 0) {
                res[j++] = nums[i];
                count--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.print("Enter k: ");
        int k = sc.nextInt();
            System.out.println(Arrays.toString(maxSubsequence(Arr1, k)));
        sc.close();    }}
