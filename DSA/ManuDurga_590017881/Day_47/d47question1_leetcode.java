package Day_47;

import java.util.*;

public class d47question1_leetcode {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[][] athletes = new int[n][2];
        for (int i = 0; i < n; i++) {
            athletes[i][0] = score[i];
            athletes[i][1] = i;
        }

        java.util.Arrays.sort(athletes, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = athletes[i][1]; 

            if (i == 0) {
                ans[index] = "Gold Medal";
            } else if (i == 1) {
                ans[index] = "Silver Medal";
            } else if (i == 2) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(i + 1);
            }
        }

        return ans;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
         System.out.println(findRelativeRanks(Arr1));
        sc.close();    }}
