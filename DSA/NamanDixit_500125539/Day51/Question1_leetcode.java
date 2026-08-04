class Question1_leetcode {

    // Function to find the most frequent EVEN element, breaking ties by smallest value
    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                countMap.merge(num, 1, Integer::sum);
            }
        }

        if (countMap.isEmpty()) {
            return -1;
        }

        int bestNumber = -1;
        int bestFrequency = -1;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > bestFrequency) {
                bestFrequency = frequency;
                bestNumber = number;
            } else if (frequency == bestFrequency && number < bestNumber) {
                bestNumber = number;
            }
        }

        return bestNumber;
    }
}