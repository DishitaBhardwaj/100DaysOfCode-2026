import java.util.*;
public class Question2 
{
    public static List<Integer> findAnagrams(String log, String pattern) 
    {
        List<Integer> ans = new ArrayList<>();
        if(pattern.length() > log.length())
            return ans;
        int[] p = new int[26];
        int[] w = new int[26];
        for(char c : pattern.toCharArray())
            p[c - 'a']++;
        for(int i = 0; i < pattern.length(); i++)
            w[log.charAt(i) - 'a']++;
        if(Arrays.equals(p, w))
            ans.add(0);
        for(int i = pattern.length(); i < log.length(); i++) 
            {
            w[log.charAt(i) - 'a']++;
            w[log.charAt(i - pattern.length()) - 'a']--;
            if(Arrays.equals(p, w))
                ans.add(i - pattern.length() + 1);
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        String log = "cbaebabacd";
        String pattern = "abc";
        System.out.println(findAnagrams(log, pattern));
    }
}