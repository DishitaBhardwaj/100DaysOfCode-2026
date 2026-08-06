import java.util.*;
public class Question1 
{
    public static boolean areOccurrencesEqual(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) 
            {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int freq = -1;
        for(int count : map.values()) 
            {
            if(freq == -1)
                freq = count;
            else if(freq != count)
                return false;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        String s = "abacbc";
        System.out.println(areOccurrencesEqual(s));
    }
}