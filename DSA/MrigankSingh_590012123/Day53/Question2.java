import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public int[] findAnagrams(String log, String pattern) {
        if (log.length() < pattern.length()) {
            return new int[0];
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            target[pattern.charAt(i) - 'a']++;
            window[log.charAt(i) - 'a']++;
        }

        List<Integer> indices = new ArrayList<>();
        if (matches(target, window)) {
            indices.add(0);
        }

        for (int right = pattern.length(); right < log.length(); right++) {
            window[log.charAt(right) - 'a']++;
            window[log.charAt(right - pattern.length()) - 'a']--;

            if (matches(target, window)) {
                indices.add(right - pattern.length() + 1);
            }
        }

        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }

        return result;
    }

    private boolean matches(int[] target, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (target[i] != window[i]) {
                return false;
            }
        }

        return true;
    }
}