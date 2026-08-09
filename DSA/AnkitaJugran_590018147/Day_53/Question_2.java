import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Anagrams {

    //method to find anagrams
    public List<Integer> findAnagrams( String log, String pattern ){

        List<Integer> ans = new ArrayList<>();

        if ( log.length() < pattern.length() ) {
            
            return ans;
        }

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        // storing frequency of pattern
        for ( int i = 0; i < pattern.length(); i++ ) {

            patternFreq[pattern.charAt(i) - 'a']++;
        }

        // storing frequency of first window
        for ( int i = 0; i < pattern.length(); i++ ) {

            windowFreq[log.charAt(i) - 'a']++;
        }

        // Check first window
        if ( Arrays.equals( patternFreq, windowFreq ) ) {
            ans.add(0);
        }

        // Slide the window
        for ( int i = pattern.length(); i < log.length(); i++ ) {

            // Remove leftmost character
            windowFreq[log.charAt(i - pattern.length()) - 'a']--;

            // Add new character
            windowFreq[log.charAt(i) - 'a']++;

            // Compare frequencies
            if (Arrays.equals(patternFreq, windowFreq)) {
                ans.add(i - pattern.length() + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String log = "cbaebabacd";
        String pattern = "abc";

        Find_Anagrams obj = new Find_Anagrams();

        List<Integer> result = obj.findAnagrams(log, pattern);

        System.out.println(result);
    }

    
}
