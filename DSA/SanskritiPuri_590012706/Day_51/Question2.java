import java.util.HashMap;

public class Solution {

    public static int firstInvalidRecord(String[][] deliveries) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {
            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];

            String key = vendor + "#" + lot;

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else {
                if (!map.get(key).equals(cert)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String[][] deliveries1 = {
            {"V1", "L100", "A"},
            {"V2", "L200", "B"},
            {"V1", "L100", "A"},
            {"V1", "L100", "C"}
        };

        String[][] deliveries2 = {
            {"V1", "L100", "A"},
            {"V1", "L101", "A"},
            {"V2", "L100", "A"}
        };

        String[][] deliveries3 = {
            {"V3", "L500", "X"},
            {"V3", "L500", "Y"}
        };

        System.out.println(firstInvalidRecord(deliveries1)); // 3
        System.out.println(firstInvalidRecord(deliveries2)); // -1
        System.out.println(firstInvalidRecord(deliveries3)); // 1
    }
}
