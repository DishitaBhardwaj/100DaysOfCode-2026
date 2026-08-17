import java.util.*;

public class Question1_Leetcode {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        input = input.replaceAll("\\s+", "");

        int nums1Start = input.indexOf("[") + 1;
        int nums1End = input.indexOf("]");

        String nums1String = input.substring(nums1Start, nums1End);

        String remaining = input.substring(nums1End + 1);

        int mStart = remaining.indexOf("m=") + 2;
        int mEnd = remaining.indexOf(",", mStart);

        int m = Integer.parseInt(
                remaining.substring(mStart, mEnd)
        );

        int nums2Start = remaining.indexOf("[", mEnd) + 1;
        int nums2End = remaining.indexOf("]", nums2Start);

        String nums2String = remaining.substring(
                nums2Start,
                nums2End
        );

        int nStart = remaining.indexOf("n=", nums2End) + 2;

        int n = Integer.parseInt(
                remaining.substring(nStart)
        );

        int[] nums1;

        if (nums1String.isEmpty()) {
            nums1 = new int[m + n];
        } else {
            String[] values1 = nums1String.split(",");

            nums1 = new int[values1.length];

            for (int i = 0; i < values1.length; i++) {
                nums1[i] = Integer.parseInt(values1[i]);
            }
        }

        int[] nums2;

        if (nums2String.isEmpty()) {
            nums2 = new int[0];
        } else {
            String[] values2 = nums2String.split(",");

            nums2 = new int[values2.length];

            for (int i = 0; i < values2.length; i++) {
                nums2[i] = Integer.parseInt(values2[i]);
            }
        }

        merge(nums1, m, nums2, n);

        System.out.print("[");

        for (int i = 0; i < nums1.length; i++) {

            System.out.print(nums1[i]);

            if (i < nums1.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}