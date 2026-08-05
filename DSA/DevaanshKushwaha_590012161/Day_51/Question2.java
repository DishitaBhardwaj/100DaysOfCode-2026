import java.util.HashMap;
import java.util.List;

class Solution {
    public int findFirstMismatch(List<int[]> records) {
        // Key: "vendorId_lotNumber" -> first-seen cert_code
        HashMap<String, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < records.size(); i++) {
            int[] record = records.get(i);
            int vendorId = record[0];
            int lotNumber = record[1];
            int certCode = record[2];
            
            // Composite key for the (vendor_id, lot_number) pair
            String key = vendorId + "_" + lotNumber;
            
            if (seen.containsKey(key)) {
                // Pair seen before — check if cert_code matches
                if (seen.get(key) != certCode) {
                    return i; // Mismatch found
                }
            } else {
                // First time seeing this pair — record its cert_code
                seen.put(key, certCode);
            }
        }
        
        return -1; // All records consistent
    }
}
