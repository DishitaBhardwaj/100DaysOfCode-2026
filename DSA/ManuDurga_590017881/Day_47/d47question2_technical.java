package Day_47;

import java.util.*;

public class d47question2_technical {
    public static int kthElement(int[] A, int[] B, int k) {
    int i = 0, j = 0, count = 0;

    while (i < A.length && j < B.length) {
        int val;
        if (A[i] <= B[j]) {
            val = A[i++];
        } else {
            val = B[j++];
        }
        count++;
        if (count == k) return val;
    }

    while (i < A.length) {
        count++;
        if (count == k) return A[i];
        i++;
    }

    while (j < B.length) {
        count++;
        if (count == k) return B[j];
        j++;
    }

    return -1;
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
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.println(kthElement(Arr1,Arr2,k));
        sc.close();}}
