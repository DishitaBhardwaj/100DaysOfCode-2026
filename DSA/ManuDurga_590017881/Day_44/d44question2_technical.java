package Day_44;

import java.util.*;

public class d44question2_technical {
    public static String FavElementSaved(int[] nums, int f, int k) {
        int fav = nums[f - 1];  
        
        int greater = 0, equal = 0;
        for (int num : nums) {
            if (num > fav) greater++;
            else if (num == fav) equal++;
        }
        
        if (k <= greater) return "NO";          
        else if (k >= greater + equal) return "YES";
        else return "MAYBE";     
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr1 = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.print("favoriteIndex: ");
        int fav = sc.nextInt();
        System.out.print("k: ");
        int k = sc.nextInt();
        System.out.println(FavElementSaved(Arr1,fav,k));
        sc.close();
    }
}
