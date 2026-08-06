import java.util.ArrayList;
import java.util.List;
public class Question2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> a = new ArrayList<>();
        if (s.length() < p.length()) return a;
        int[] f = new int[26];
        for (char c : p.toCharArray()) f[c - 'a']++;
        int l = 0, r = 0, k = p.length();
        while (r < s.length()) {
            if (f[s.charAt(r++) - 'a']-- > 0) k--;
            if (k == 0) a.add(l);
            if (r - l == p.length() && f[s.charAt(l++) - 'a']++ >= 0) k++;
        } return a;
    }
}
