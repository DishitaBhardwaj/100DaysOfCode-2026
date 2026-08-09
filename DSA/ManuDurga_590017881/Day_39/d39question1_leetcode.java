package Day_39;

import java.util.*;

public class d39question1_leetcode {
    
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int c=0;
        int i =0;
        while(tickets[k]!=0){
            tickets[i]--;
            System.out.println(tickets[i]);
            if(tickets[i]>-1){c++;}
            if(i+1==tickets.length){System.out.println(" limit ");
                i=0;}
            else{i++;}
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr1 = new int[n];
        int m = sc.nextInt();
        System.out.print(timeRequiredToBuy(Arr1, m));
        sc.close();
    }}

