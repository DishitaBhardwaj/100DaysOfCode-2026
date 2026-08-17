package Day_46;

import java.util.*;

public class d46question2_technical {
    public static int maximumPrefixDifferenceScore(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[n - 1];

        return (n - 2) * (max - min);
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr1 = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.println(maximumPrefixDifferenceScore(Arr1));
        sc.close();}}
