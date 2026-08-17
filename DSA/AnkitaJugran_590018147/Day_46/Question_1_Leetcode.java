class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hsh_set = new HashSet<>();

        for (int num : nums1) {
            hsh_set.add(num);
        }

        Set<Integer> ans = new HashSet<>();

        for (int no : nums2) {
            if (hsh_set.contains(no)) {
                ans.add(no);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;

        for (int x : ans) {
            result[i++] = x;
        }

        return result;
    }
}