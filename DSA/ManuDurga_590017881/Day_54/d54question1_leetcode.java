package Day_54;

import java.util.*;

public class d54question1_leetcode {
    public static int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        Set<Integer> Set = new HashSet<>();
        for (int num : nums) {
        Set.add(num);}
        if(nums.length>Set.size()){
            int[] counter = new int[Set.size()];
            Arrays.fill(counter, 1); 
            System.out.print(Arrays.toString(nums));
            int c =0;
            for(int i=0;i<nums.length-1;i++){if(nums[i]==nums[i+1]){counter[c]++;}
            else{c++;}
            }
            Arrays.sort(counter);
            System.out.print(Arrays.toString(counter));
            sum=counter[Set.size()-1];
            for(int i = Set.size()-1;i>0;i--){
                System.out.println(counter[i]);
                if(counter[i]==counter[i-1]&&counter[i]>1){System.out.println("Sum Added");

                    sum=sum+counter[i-1];}
                else{break;}
            }

            return sum;
            
        }
        else{return Set.size();}
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
            System.out.println(maxFrequencyElements(Arr1));
        sc.close();    }}
