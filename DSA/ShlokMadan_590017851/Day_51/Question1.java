import java.util.*;
public class Question1 
{
    public static int mostFrequentEven(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            {
            if (num % 2 == 0) 
                {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        if (map.isEmpty()) return -1;
        int ans = -1;
        int freq = 0;
        for (int key : map.keySet()) 
            {
            int count = map.get(key);
            if (count > freq || (count == freq && key < ans))
                {
                freq = count;
                ans = key;
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
    }
}