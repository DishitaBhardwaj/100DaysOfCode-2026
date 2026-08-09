import java.util.Arrays;

public class Question2 {

    public static int maximumScore(int[] nums) {

        Arrays.sort(nums);

        if(nums.length==1) {
            return 0;
        }

        int min=nums[0];
        int max=nums[nums.length-1];
        int score=0;

        for(int i=1;i<nums.length;i++) {
            score+=max-min;
        }

        return score;
    }

    public static void main(String[] args) {

        int[] nums={7,6,5};

        System.out.println(maximumScore(nums));
    }
}