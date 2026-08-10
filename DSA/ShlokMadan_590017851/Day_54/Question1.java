import java.util.*;
public class Question1 
{
    public static int maxFrequencyElements(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : map.values()) 
            {
            maxFreq = Math.max(maxFreq, freq);
        }
        int ans = 0;
        for (int freq : map.values()) 
            {
            if (freq == maxFreq) 
                {
                ans += freq;
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }
}