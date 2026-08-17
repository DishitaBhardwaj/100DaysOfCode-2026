class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Store all unique elements of nums1
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Check nums2 elements against set1, collect matches
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // Set handles duplicate matches automatically
            }
        }

        // Step 3: Convert result set to int[]
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}
