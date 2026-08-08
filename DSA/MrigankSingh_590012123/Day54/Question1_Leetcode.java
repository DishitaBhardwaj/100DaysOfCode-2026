public class Question1_Leetcode {
    public int maxFrequencyElements(int[] nums) {
        int[] frequency = new int[101];
        int maxFrequency = 0;

        for (int num : nums) {
            frequency[num]++;
            if (frequency[num] > maxFrequency) {
                maxFrequency = frequency[num];
            }
        }

        int total = 0;
        for (int count : frequency) {
            if (count == maxFrequency) {
                total += count;
            }
        }

        return total;
    }
}