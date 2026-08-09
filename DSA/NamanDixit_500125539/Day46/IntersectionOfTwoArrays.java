
class Question1_leetcode {

    // Function to find the intersection of two arrays (unique elements only)
    public int[] intersection(int[] nums1, int[] nums2) {

        // Step 1: Put all elements of nums1 into a HashSet.
        // A HashSet automatically removes duplicates, and lookups are O(1) on average.
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Use another HashSet to collect the intersection result.
        // We use a set here too, so if nums2 has duplicates that match,
        // we still only keep ONE copy in the final answer.
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            // If this number from nums2 also exists in nums1's set,
            // it's part of the intersection.
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Step 3: Convert the resultSet into a plain int array to return.
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index] = num;
            index++;
        }

        return result;
    }
}
