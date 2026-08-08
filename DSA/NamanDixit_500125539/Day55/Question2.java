
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question2 {

    // Function to select at most k songs to maximize:
    // (sum of selected lengths) x (minimum beauty among selected songs)
    public static long maxPleasure(int[] length, int[] beauty, int k) {

        int n = length.length;

        // Step 1: Combine each song's beauty and length into a single row,
        // so we can sort them together as pairs.
        // songs[i][0] = beauty, songs[i][1] = length
        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        // Step 2: Sort songs by BEAUTY in descending order.
        // This way, as we scan left to right, every song we've seen so far
        // has beauty >= the current song's beauty -- meaning the current
        // song is always the smallest beauty among everything considered so far.
        Arrays.sort(songs, (a, b) -> b[0] - a[0]);

        // Step 3: Use a MIN-HEAP to keep track of the lengths of our
        // currently selected songs. If we ever exceed k songs, we remove
        // the SMALLEST length (since we want to keep the biggest lengths
        // to maximize our sum).
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long runningSum = 0;      // sum of lengths currently in the heap
        long bestPleasure = 0;    // best (sum x minBeauty) found so far

        // Step 4: Process songs one at a time, in descending beauty order
        for (int[] song : songs) {
            int currentBeauty = song[0];
            int currentLength = song[1];

            // Add this song's length to our selection
            minHeap.add(currentLength);
            runningSum += currentLength;

            // If we now have MORE than k songs selected, remove the smallest
            // length to shrink back down to k (keeps the biggest lengths).
            if (minHeap.size() > k) {
                int removedLength = minHeap.poll();
                runningSum -= removedLength;
            }

            // Once we have exactly k songs selected, the current song's beauty
            // is the MINIMUM beauty among all of them (since we're going in
            // descending beauty order). Compute the pleasure for this selection.
            if (minHeap.size() == k) {
                long pleasure = runningSum * currentBeauty;
                bestPleasure = Math.max(bestPleasure, pleasure);
            }
        }

        return bestPleasure;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of songs
        System.out.println("Enter the number of songs:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the length array
        System.out.println("Enter " + n + " song lengths separated by spaces:");
        String[] lengthParts = scanner.nextLine().trim().split("\\s+");
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(lengthParts[i]);
        }

        // Step 3: Read the beauty array
        System.out.println("Enter " + n + " beauty values separated by spaces:");
        String[] beautyParts = scanner.nextLine().trim().split("\\s+");
        int[] beauty = new int[n];
        for (int i = 0; i < n; i++) {
            beauty[i] = Integer.parseInt(beautyParts[i]);
        }

        // Step 4: Read k
        System.out.println("Enter k (max number of songs to select):");
        int k = Integer.parseInt(scanner.nextLine().trim());

        // Step 5: Call the function and print the result
        long result = maxPleasure(length, beauty, k);

        System.out.println("Maximum playlist pleasure: " + result);

        scanner.close();
    }
}
