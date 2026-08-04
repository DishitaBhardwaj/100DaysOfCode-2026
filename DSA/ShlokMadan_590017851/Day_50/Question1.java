import java.util.Arrays;
public class Question1 
{
    public static int[] getFinalState(int[] nums, int k, int multiplier) 
    {
        while (k > 0) 
            {
            int minIndex = 0;
            for (int i = 1; i < nums.length; i++) 
                {
                if (nums[i] < nums[minIndex]) 
                    {
                    minIndex = i;
                }
            }
            nums[minIndex] *= multiplier;
            k--;
        }
        return nums;
    }
    public static void main(String[] args) 
    {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }
}