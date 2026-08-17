
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Question2 {

    // Function to process a list of username requests and return the
    // actual registered username for each request ("OK" if available as-is,
    // or "name+number" if a suffix had to be appended to make it unique).
    public static String[] processRegistrations(String[] requests) {

        int n = requests.length;
        String[] results = new String[n];

        // Set to track EVERY username that currently exists (original or suffixed)
        Set<String> usedNames = new HashSet<>();

        // Map to remember, for each BASE username, the next suffix number to try.
        // This avoids re-checking from 1 every time -- we pick up where we left off.
        Map<String, Integer> nextSuffix = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = requests[i];

            if (!usedNames.contains(name)) {
                // Username is free! Register it as-is.
                usedNames.add(name);
                results[i] = "OK";

                // Make sure we have a starting suffix counter for this base name,
                // in case it collides with something later.
                nextSuffix.putIfAbsent(name, 1);

            } else {
                // Username is already taken -- we need to find the smallest
                // positive integer suffix that makes it unique.

                // Start checking from wherever we left off last time for this base name
                int suffix = nextSuffix.getOrDefault(name, 1);

                // Keep incrementing the suffix until we find a name that's NOT taken
                while (usedNames.contains(name + suffix)) {
                    suffix++;
                }

                // Found a free name! Register it.
                String newName = name + suffix;
                usedNames.add(newName);
                results[i] = newName;

                // Remember that the NEXT time this base name collides,
                // we should start checking from (suffix + 1) onward.
                nextSuffix.put(name, suffix + 1);
            }
        }

        return results;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of registration requests
        System.out.println("Enter the number of registration requests:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read the requested usernames, one per line
        String[] requests = new String[n];
        System.out.println("Enter " + n + " usernames, one per line:");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextLine().trim();
        }

        // Step 3: Call the function and print the result
        String[] result = processRegistrations(requests);

        System.out.println("Registration results: " + Arrays.toString(result));

        scanner.close();
    }
}
