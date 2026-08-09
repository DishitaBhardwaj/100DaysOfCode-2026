public class Question1_Leetcode {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        boolean[] added = new boolean[1001];
        
        for (int num : nums1) {
            seen[num] = true;
        }      
        int count = 0;
        for (int num : nums2) {
            if (seen[num] && !added[num]) {
                added[num] = true;
                count++;
            }
        }       
        int[] result = new int[count];
        int i = 0;
        for (int num = 0; num <= 1000; num++) {
            if (added[num]) {
                result[i++] = num;
            }
        }
        return result;
    }
}