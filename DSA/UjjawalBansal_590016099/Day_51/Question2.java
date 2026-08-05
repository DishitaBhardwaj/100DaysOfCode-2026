import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question2 {
    public static int receivingLogValidation(String[][] deliveries) {
        Map<String, String> history = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {
            String vId = deliveries[i][0];
            String lNumber = deliveries[i][1];
            String certCode = deliveries[i][2];

            String key = vId + "_" + lNumber;

            if (history.containsKey(key)) {
                String expectedCertCode = history.get(key);
                
                if (!expectedCertCode.equals(certCode)) {
                    return i;
                }
            } 
            else {
                history.put(key, certCode);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of delivery records:");
        int n = sc.nextInt();
            
        String[][] deliveries = new String[n][3];
        System.out.println("Enter the " + n + " delivery records (vendor_id lot_number cert_code) separated by spaces:");
        for (int i = 0; i < n; i++) {
            deliveries[i][0] = sc.next();
            deliveries[i][1] = sc.next();
            deliveries[i][2] = sc.next();
        }
            
        int result = receivingLogValidation(deliveries);
        
        if (result == -1) {
            System.out.println("All delivery records are valid. Output: -1");
        } 
        else {
            System.out.println("Rule violation detected! First invalid delivery found at index: " + result);
        }
        sc.close();
    }
}