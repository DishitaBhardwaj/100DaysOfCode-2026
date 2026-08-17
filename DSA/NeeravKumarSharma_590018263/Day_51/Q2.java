import java.util.HashMap;
import java.util.Map;

public class Q2 {

    public static int findFirstConflict(String[][] records) {
        Map<String, String> registeredCerts = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String vendorId = records[i][0];
            String lotNumber = records[i][1];
            String certCode = records[i][2];

            String key = vendorId + ":" + lotNumber;

            if (registeredCerts.containsKey(key)) {
                if (!registeredCerts.get(key).equals(certCode)) {
                    return i; 
                }
            } else {
                registeredCerts.put(key, certCode);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[][] records = {
            {"V001", "L-99", "CERT-A"},
            {"V002", "L-15", "CERT-B"},
            {"V001", "L-99", "CERT-A"}, 
            {"V003", "L-99", "CERT-A"}, 
            {"V001", "L-99", "CERT-X"}  
        };

        System.out.println("Output: " + findFirstConflict(records));
    }
}