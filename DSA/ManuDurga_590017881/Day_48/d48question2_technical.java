package Day_48;

import java.util.*;

public class d48question2_technical {
    public static int[] constructArray(int n, int[] b) {
        Arrays.sort(b);

        int[] a = new int[n];
        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[index];
            index += (n - i - 1);
        }

        // Last element can be any value greater than all values
        a[n - 1] = 10000000;

        return a;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int k = sc.nextInt();
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i] = sc.nextInt();}

        System.out.println(Arrays.toString(constructArray(k, Arr1)));
        sc.close();}}
