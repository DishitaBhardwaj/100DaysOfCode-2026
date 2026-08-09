import java.util.*;

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of delivery records: ");
        int n = sc.nextInt();

        HashMap<String, String> map = new HashMap<>();

        System.out.println("Enter vendor_id lot_number cert_code:");

        for (int i = 0; i < n; i++) {
            String vendor = sc.next();
            String lot = sc.next();
            String cert = sc.next();

            String key = vendor + "#" + lot;

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else if (!map.get(key).equals(cert)) {
                System.out.println("First Invalid Record Index: " + i);
                return;
            }
        }

        System.out.println("First Invalid Record Index: -1");
    }
}