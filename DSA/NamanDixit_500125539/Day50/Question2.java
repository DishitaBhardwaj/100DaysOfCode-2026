
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question2 {

    // Function to repeatedly smash the two heaviest rocks together
    // until at most one rock remains, and return its final weight.
    public static int lastStoneWeight(int[] rocks) {

        // Step 1: Create a MAX-HEAP (PriorityQueue normally gives the SMALLEST
        // element first, so we use Collections.reverseOrder() to flip it,
        // making it always give us the LARGEST rock first).
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 2: Add every rock's weight into the heap
        for (int rock : rocks) {
            maxHeap.add(rock);
        }

        // Step 3: Keep smashing rocks together as long as there are at least 2 left
        while (maxHeap.size() > 1) {

            // Take out the two heaviest rocks currently in the heap
            int heaviest = maxHeap.poll();       // biggest rock
            int secondHeaviest = maxHeap.poll();  // second biggest rock

            // If they're not equal, the difference survives as a new (smaller) rock
            if (heaviest != secondHeaviest) {
                int remaining = heaviest - secondHeaviest;
                maxHeap.add(remaining); // put the leftover rock back into the heap
            }
            // If they ARE equal, both rocks are completely destroyed --
            // we simply don't add anything back.
        }

        // Step 4: After the loop, either 1 rock remains (return its weight)
        // or 0 rocks remain (return 0, since there's nothing left).
        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.poll();
        }
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of rocks
        System.out.println("Enter the number of rocks:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the weights of the rocks
        System.out.println("Enter " + n + " rock weights, separated by spaces:");
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] rocks = new int[n];
        for (int i = 0; i < n; i++) {
            rocks[i] = Integer.parseInt(parts[i]);
        }

        // Step 3: Call the function and print the result
        int result = lastStoneWeight(rocks);

        System.out.println("Final remaining rock weight: " + result);

        scanner.close();
    }
}
