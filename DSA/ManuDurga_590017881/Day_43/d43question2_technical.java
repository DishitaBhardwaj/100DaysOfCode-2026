package Day_43;

import java.util.*;

public class d43question2_technical {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr1 = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.println(arrayPairSum(Arr1));
        sc.close();
    }
}
