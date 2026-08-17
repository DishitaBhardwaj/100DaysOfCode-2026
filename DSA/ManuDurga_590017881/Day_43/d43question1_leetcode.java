package Day_43;

import java.util.Arrays;
import java.util.Scanner;

public class d43question1_leetcode {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       
        int j = n - 1;       
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    System.out.println(Arrays.toString(nums1));}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        System.out.print("Enter Size of Array: ");
        int n2= sc.nextInt();
        int[] Arr1 = new int[n1+n2];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.println(Arrays.toString(Arr1));
        int[] Arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            System.out.print(": ");
            Arr2[i]=sc.nextInt();}
        merge(Arr1, n1, Arr2, n2);
        sc.close();    }
}
