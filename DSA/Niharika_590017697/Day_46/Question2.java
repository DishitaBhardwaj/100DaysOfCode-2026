import java.util.*;
public class Main 
{
    public static long maximumScore(int[] nums) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int minPrefix = Integer.MAX_VALUE;
        int maxPrefix = Integer.MIN_VALUE;
        long score = 0;

        for (int i = 0; i < n; i++) 
        {
            int current;
            if (i % 2 == 0) 
            {
                current = nums[left++];
            } 
            else 
            {
                current = nums[right--];
            }
            minPrefix = Math.min(minPrefix, current);
            maxPrefix = Math.max(maxPrefix, current);
            score += (maxPrefix - minPrefix);
        }
        return score;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in)
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) 
        {
            nums[i] = sc.nextInt();
        }
        System.out.println(maximumScore(nums));

        sc.close();
    }
}