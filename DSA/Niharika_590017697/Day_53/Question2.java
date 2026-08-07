import java.util.*;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String log = sc.next();
        String pattern = sc.next();
        System.out.println(findAnagrams(log, pattern));
    }

    public static List<Integer> findAnagrams(String log, String pattern) 
    {
        List<Integer> result = new ArrayList<>();
        if (pattern.length() > log.length()) 
        {
            return result;
        }

        int[] pCount = new int[26];
        int[] wCount = new int[26];

        for (int i = 0; i < pattern.length(); i++) 
        {
            pCount[pattern.charAt(i) - 'a']++;
            wCount[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, wCount)) 
        {
            result.add(0);
        }

        for (int i = pattern.length(); i < log.length(); i++) 
        {
            wCount[log.charAt(i) - 'a']++;
            wCount[log.charAt(i - pattern.length()) - 'a']--;

            if (Arrays.equals(pCount, wCount)) 
            {
                result.add(i - pattern.length() + 1);
            }
        }

        return result;
    }
}