public class Question1_LeetCode {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            arr[nums1[i]] = 1;
        }
        
        int a = 0;

        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] > 0) {
                nums1[a++] = nums2[i];
                arr[nums2[i]]--;
            }
        }
        return Arrays.copyOfRange(nums1, 0, a);
    }
}
