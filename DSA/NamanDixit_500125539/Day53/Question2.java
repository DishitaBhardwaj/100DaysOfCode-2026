import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question2 {

    // Function to find all starting indices in 'log' where a substring
    // is an anagram of 'pattern'.
    public static List<Integer> findAnagrams(String log, String pattern) {

        List<Integer> result = new ArrayList<>();

        int logLength = log.length();
        int patternLength = pattern.length();

        // If the log is shorter than the pattern, no anagram can possibly fit
        if (logLength < patternLength) {
            return result;
        }

        // Step 1: Build a frequency count of the pattern's characters.
        // Index 0 = 'a', index 1 = 'b', ..., index 25 = 'z'
        int[] patternCount = new int[26];
        for (int i = 0; i < patternLength; i++) {
            patternCount[pattern.charAt(i) - 'a']++;
        }

        // Step 2: Build a frequency count for the CURRENT sliding window in log.
        int[] windowCount = new int[26];

        // Step 3: Slide a window of size 'patternLength' across the log.
        for (int i = 0; i < logLength; i++) {

            // Add the new character entering the window (at position i)
            windowCount[log.charAt(i) - 'a']++;

            // If our window has grown bigger than patternLength,
            // remove the character that's now falling OUT of the window
            // (the one at position i - patternLength).
            if (i >= patternLength) {
                windowCount[log.charAt(i - patternLength) - 'a']--;
            }

            // Step 4: Once the window reaches the correct size (from index
            // patternLength - 1 onward), compare it against the pattern's frequency.
            if (i >= patternLength - 1) {
                if (Arrays.equals(windowCount, patternCount)) {
                    // The window matches! Its starting index is (i - patternLength + 1)
                    result.add(i - patternLength + 1);
                }
            }
        }

        return result;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the log string
        System.out.println("Enter the log string:");
        String log = scanner.nextLine().trim();

        // Step 2: Read the pattern string
        System.out.println("Enter the pattern string:");
        String pattern = scanner.nextLine().trim();

        // Step 3: Call the function and print the result
        List<Integer> result = findAnagrams(log, pattern);

        System.out.println("Starting indices of anagrams: " + result);

        scanner.close();
    }
}