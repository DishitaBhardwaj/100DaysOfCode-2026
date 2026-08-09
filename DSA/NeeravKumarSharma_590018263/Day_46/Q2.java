public class Q2 {

    public static int maximizePrefixDifference(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int maxVal = nums[maxIdx];
        int minVal = nums[minIdx];

        swap(nums, 0, maxIdx);
        
        if (minIdx == 0) {
            minIdx = maxIdx;
        }
        
        swap(nums, 1, minIdx);

        return (nums.length - 1) * (maxVal - minVal);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 5};
        System.out.println("Output: " + maximizePrefixDifference(nums));
    }
}