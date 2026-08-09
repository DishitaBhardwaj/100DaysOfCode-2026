import java.util.*;

public class Question2{
    public static int firstInvalidRecord(List<List<String>> deliveries) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.size(); i++) {
            List<String> record = deliveries.get(i);

            String vendor = record.get(0);
            String lot = record.get(1);
            String cert = record.get(2);

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
        List<List<String>> deliveries = new ArrayList<>();
        
        deliveries.add(Arrays.asList("V1", "L100", "A"));
        deliveries.add(Arrays.asList("V2", "L200", "B"));
        deliveries.add(Arrays.asList("V1", "L100", "A"));
        deliveries.add(Arrays.asList("V1", "L100", "C"));

        System.out.println(firstInvalidRecord(deliveries)); 
    }
}