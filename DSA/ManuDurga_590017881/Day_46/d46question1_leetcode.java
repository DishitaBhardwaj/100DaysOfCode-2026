package Day_46;

import java.util.*;

public class d46question1_leetcode {
    public static int[] intersection(int[] nums1, int[] nums2) {
         HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;

        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
         System.out.print("Enter Size of Array: ");
        int n2 = sc.nextInt();
        int[] Arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
         System.out.println(intersection(Arr1,Arr2));
        sc.close();    }}
