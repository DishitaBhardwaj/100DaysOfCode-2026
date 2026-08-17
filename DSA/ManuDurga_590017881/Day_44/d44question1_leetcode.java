package Day_44;

import java.util.Arrays;
import java.util.Scanner;

public class d44question1_leetcode {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-2;i++){
            if(arr[i]-arr[i+1]!=arr[i+1]-arr[i+2]){return false;}
        }
        return true;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.println(canMakeArithmeticProgression(Arr1));
        sc.close();    }
}
