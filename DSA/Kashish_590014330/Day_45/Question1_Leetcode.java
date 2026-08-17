import java.util.*;
public class Question1_Leetcode{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size");
        int n=sc.nextInt();
        System.out.println("Enter target  value");
        int target=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();

        }
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                System.out.println(i);
                break;
            }
            else if (nums[i]>target){
                System.out.println(i);
                break;
                
                

            }
        }
        System.out.println(n);

    }
}