import java.util.*;

public class Question2 {

    public static int firstInvalidRecord(List<List<String>> deliveries) {

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.size(); i++) {

            String vendor = deliveries.get(i).get(0);
            String lot = deliveries.get(i).get(1);
            String cert = deliveries.get(i).get(2);

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

}