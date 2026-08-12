public class Question1_Leetcode {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            char third = s.charAt(i + 2);

            if (first != second && first != third && second != third) {
                count++;
            }
        }

        return count;
    }
}