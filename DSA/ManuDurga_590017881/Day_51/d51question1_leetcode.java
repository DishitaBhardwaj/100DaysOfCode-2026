package Day_51;

import java.util.*;

public class d51question1_leetcode {
    public static int mostFrequentEven(int[] nums) {
        int bigIn = 0;
        int bigNo = -1;
        int count = 1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count = 1;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                if (count > bigIn) {
                    bigIn = count;
                    bigNo = nums[i];
                }
            }
        }

        return bigNo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
            System.out.println(mostFrequentEven(Arr1));
        sc.close();    }}
