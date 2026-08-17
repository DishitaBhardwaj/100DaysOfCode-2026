import java.util.*;

public class Question1_Leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter String:");
        String str = sc.nextLine(); 
        
        int[] freq = new int[26];
    
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }
        int targetCount = freq[str.charAt(0) - 'a'];
        boolean isPass = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] != targetCount) {
                isPass = false;
                break;
            }
        }
        
        System.out.println("Result: " + isPass);
        sc.close();
    }
}