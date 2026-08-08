
class Question1_leetcode {

    // Function to calculate total count of elements having maximum frequency
    public static int maxFrequencyElements(int[] nums) {
        // Step 1: Create a HashMap to keep track of the frequency (count) of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Variable to keep track of the highest frequency encountered so far
        int maxFreq = 0;

        // Step 2: Loop through the array and count how many times each number appears
        for (int num : nums) {
            // Get the current count for 'num' (defaults to 0 if not present) and add 1
            int currentFreq = frequencyMap.getOrDefault(num, 0) + 1;

            // Put the updated frequency back into the map
            frequencyMap.put(num, currentFreq);

            // Keep track of the overall maximum frequency seen so far
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
            }
        }

        // Variable to store the final answer (total sum of frequencies)
        int totalFrequency = 0;

        // Step 3: Loop through all frequencies in the map
        for (int count : frequencyMap.values()) {
            // If an element's frequency matches the maximum frequency, add it to our total
            if (count == maxFreq) {
                totalFrequency += count;
            }
        }

        // Return the calculated total
        return totalFrequency;
    }
}
