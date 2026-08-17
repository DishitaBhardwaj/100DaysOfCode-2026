import java.util.HashSet;
import java.util.Set;

public class Problem1_Leetcode {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for (int num : nums1) {
            first.add(num);
        }

        for (int num : nums2) {
            if (first.contains(num)) {
                common.add(num);
            }
        }

        int[] result = new int[common.size()];
        int index = 0;
        for (int value : common) {
            result[index++] = value;
        }

        return result;
    }
}