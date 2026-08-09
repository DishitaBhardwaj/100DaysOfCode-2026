package Heap;
import java.util.*;

public class Receiving_Log_Validation {

    public static int firstInvalidRecord(int[][] records) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            int vendorId = records[i][0];
            int lotNumber = records[i][1];
            int certCode = records[i][2];

            // Create a unique key for (vendorId, lotNumber)
            String key = vendorId + "#" + lotNumber;

            if (!map.containsKey(key)) {
                map.put(key, certCode);
            } else {
                if (map.get(key) != certCode) {
                    return i; // First invalid record found
                }
            }
        }

        return -1; // All records are valid
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of records
        int n = sc.nextInt();

        int[][] records = new int[n][3];

        // Input records
        for (int i = 0; i < n; i++) {
            records[i][0] = sc.nextInt(); // vendor_id
            records[i][1] = sc.nextInt(); // lot_number
            records[i][2] = sc.nextInt(); // cert_code
        }

        int result = firstInvalidRecord(records);
        System.out.println(result);

        sc.close();
    }
}