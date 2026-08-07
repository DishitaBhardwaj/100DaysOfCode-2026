import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public static List<Integer> theSecurityScanner(String log, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] patternArr = new int[26];
        int[] windowArr = new int[26];
        int pLen = pattern.length();

        for (int i = 0; i < pLen; i++) {
            patternArr[pattern.charAt(i) - 'a']++;
            windowArr[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(patternArr, windowArr)) {
            result.add(0);
        }
        for (int i = pLen; i < log.length(); i++) {
            char ch = log.charAt(i);
            windowArr[ch - 'a']++;
            
            char ch2 = log.charAt(i - pLen);
            windowArr[ch2 - 'a']--;

            if (Arrays.equals(patternArr, windowArr)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the security log string: ");
        String log = sc.nextLine();
        
        System.out.println("Enter the suspicious pattern: ");
        String pattern = sc.nextLine();

        List<Integer> ans = theSecurityScanner(log, pattern);
            
        System.out.println("Suspicious patterns: " + ans); 
        sc.close();
    }
}