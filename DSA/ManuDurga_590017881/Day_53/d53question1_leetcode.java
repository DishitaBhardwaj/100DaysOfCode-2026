package Day_53;

import java.util.*;

public class d53question1_leetcode {
    public static int countGoodSubstrings(String s) {
        int count =0;
        char[] S = s.toCharArray();
        for(int i =0; i<S.length-2;i++){
            if(S[i]!=S[i+1]&&S[i+1]!=S[i+2]&&S[i]!=S[i+2]){count++;}
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.nextLine();
            System.out.println(countGoodSubstrings(s));
        sc.close();    }}
