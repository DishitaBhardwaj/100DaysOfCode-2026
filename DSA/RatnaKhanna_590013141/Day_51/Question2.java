import java.util.*;

public class Main {

    public static int firstInvalidRecord(String[][] deliveries) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {

            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];

            String key = vendor + "#" + lot;

            if (map.containsKey(key)) {
                if (!map.get(key).equals(cert)) {
                    return i;
                }
            } else {
                map.put(key, cert);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] deliveries = new String[n][3];

        for (int i = 0; i < n; i++) {
            deliveries[i][0] = sc.next();
            deliveries[i][1] = sc.next();
            deliveries[i][2] = sc.next();
        }

        System.out.println(firstInvalidRecord(deliveries));
    }
}
