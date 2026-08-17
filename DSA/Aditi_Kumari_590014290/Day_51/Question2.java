package Day_51;
import java.util.*;
public class Question2 {
    public int validateDeliveries(String[][] deliveries) {

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
}
