import java.util.*;
public class Question2 {
    public static int firstInvalidRecord(String[][] deliveries) {
        int n = deliveries.length;
        Map<String, Map<String, String>> vendorMap = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            String vendorId = deliveries[i][0];
            String lotNumber = deliveries[i][1];
            String certCode = deliveries[i][2];

            Map<String, String> lotMap = vendorMap.get(vendorId);
            if (lotMap == null) {
                lotMap = new HashMap<>(4);
                vendorMap.put(vendorId, lotMap);
            }
            String prevCert = lotMap.get(lotNumber);
            if (prevCert == null) {
                lotMap.put(lotNumber, certCode);
            } else if (!prevCert.equals(certCode)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of delivery records: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] deliveries = new String[n][3];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter record " + i + " (vendor_id lot_number cert_code): ");
            String[] parts = sc.nextLine().trim().split("\\s+");
            deliveries[i][0] = parts[0];
            deliveries[i][1] = parts[1];
            deliveries[i][2] = parts[2];
        }
        System.out.println("Index of first invalid record: " + firstInvalidRecord(deliveries));
        sc.close();
    }
}