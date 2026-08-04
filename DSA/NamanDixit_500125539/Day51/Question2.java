
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Question2 {

    // Function to find the index of the first invalid record.
    // A record is invalid if the same (vendor_id, lot_number) pair
    // was seen before with a DIFFERENT cert_code.
    public static int findFirstInvalidRecord(String[][] records) {

        // Step 1: Create a map to remember the FIRST cert_code seen
        // for each (vendor_id, lot_number) combination.
        // We combine vendor_id and lot_number into a single key string,
        // separated by a delimiter (like "|") that won't appear in real IDs.
        Map<String, String> firstCertCodeSeen = new HashMap<>();

        // Step 2: Walk through the records in order (this order matters!)
        for (int i = 0; i < records.length; i++) {

            String vendorId = records[i][0];
            String lotNumber = records[i][1];
            String certCode = records[i][2];

            // Build a combined key representing this (vendor_id, lot_number) pair
            String key = vendorId + "|" + lotNumber;

            if (firstCertCodeSeen.containsKey(key)) {
                // We've seen this vendor+lot combination before.
                // Check if the cert_code matches what we recorded earlier.
                String previousCertCode = firstCertCodeSeen.get(key);

                if (!previousCertCode.equals(certCode)) {
                    // Mismatch found! This is the first invalid record.
                    return i;
                }
                // If it matches, this record is fine -- move on to the next one.

            } else {
                // First time seeing this vendor+lot combination.
                // Remember its cert_code for future comparisons.
                firstCertCodeSeen.put(key, certCode);
            }
        }

        // If we finish the loop without finding any mismatch, everything is valid.
        return -1;
    }

    // Main method: takes user input and prints the result
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of records
        System.out.println("Enter the number of records:");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Step 2: Read each record: vendor_id, lot_number, cert_code
        String[][] records = new String[n][3];
        System.out.println("Enter each record as: vendor_id lot_number cert_code (one record per line):");
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            records[i][0] = parts[0]; // vendor_id
            records[i][1] = parts[1]; // lot_number
            records[i][2] = parts[2]; // cert_code
        }

        // Step 3: Call the function and print the result
        int result = findFirstInvalidRecord(records);

        if (result == -1) {
            System.out.println("All records are valid. Output: -1");
        } else {
            System.out.println("First invalid record found at index: " + result);
        }

        scanner.close();
    }
}
