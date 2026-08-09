<h2 align="center">Day 53</h2>

## 1. Substrings of Size Three with Distinct Characters
### Solution
```java
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i + 2 < s.length(); i++) {
            char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }
}
```
**Approach:** Slide a window of size 3 across the string and check that all three characters are distinct.

**Complexity:** Time — O(n), Space — O(1)

---

## 2. The Security Scanner (Find All Anagrams)
### Solution
```java
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = log.length(), m = pattern.length();
        if (m > n) return result;

        int[] patternCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < m; i++) {
            patternCount[pattern.charAt(i) - 'a']++;
            windowCount[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(patternCount, windowCount)) {
            result.add(0);
        }

        for (int i = m; i < n; i++) {
            windowCount[log.charAt(i) - 'a']++;
            windowCount[log.charAt(i - m) - 'a']--;

            if (Arrays.equals(patternCount, windowCount)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }
}
```
**Approach:**
- Build a frequency array of `pattern`'s 26 letters, and a frequency array for the first window of `log` (same length as `pattern`).
- Slide the window one character at a time: add the new character entering the window, remove the one leaving it.
- After each slide, compare the two frequency arrays — if they match, the current window is an anagram, so record its starting index.

**Complexity:** Time — O(n × 26) ≈ O(n), Space — O(1) (fixed-size 26-element arrays)
