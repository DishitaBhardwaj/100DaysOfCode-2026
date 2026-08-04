package Day_48;

import java.util.*;

public class d48question1_leetcode {
    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        System.out.print("Enter Size of Array: ");
        int n2 = sc.nextInt();
        int[][] Arr1 = new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j =0; j<n2;j++){
            System.out.print(": ");
            Arr1[i][j]=sc.nextInt();}}
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        int[][] sorted = sortTheStudents(Arr1, k);
        for (int[] row : sorted) {
            System.out.println(Arrays.toString(row));
        };
        sc.close();    }}
