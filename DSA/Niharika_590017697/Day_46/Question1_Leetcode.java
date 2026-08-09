class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        java.util.HashSet<Integer> set1 = new java.util.HashSet<>();
        for (int num : nums1) 
        {
            set1.add(num);
        }
        java.util.HashSet<Integer> resultSet = new java.util.HashSet<>();
        for (int num : nums2) 
        {
            if (set1.contains(num)) 
            {
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;

        for (int num : resultSet) 
        {
            result[i++] = num;
        }

        return result;
    }
}
