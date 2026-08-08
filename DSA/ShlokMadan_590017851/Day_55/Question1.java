import java.util.*;
public class Question1 
{
    public static int[] maxSubsequence(int[] nums, int k) 
    {
        int n = nums.length;
        Integer[] index = new Integer[n];
        for(int i = 0; i < n; i++) 
            {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> nums[b] - nums[a]);
        int[] ans = new int[k];
        int[] selected = new int[k];
        for(int i = 0; i < k; i++) 
            {
            selected[i] = index[i];
        }
        Arrays.sort(selected);
        for(int i = 0; i < k; i++) 
            {
            ans[i] = nums[selected[i]];
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] nums = {2, 1, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }
}