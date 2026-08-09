import java.util.*;
public class Question2 
{
    public static int firstInvalidRecord(String[][] deliveries) 
    {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < deliveries.length; i++) 
            {
            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];
            String key = vendor + "#" + lot;
            if (map.containsKey(key)) 
                {
                if (!map.get(key).equals(cert)) 
                    {
                    return i;
                }
            } 
            else 
                {
                map.put(key, cert);
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        String[][] deliveries = {
            {"V1","L100","A"},
            {"V2","L200","B"},
            {"V1","L100","A"},
            {"V1","L100","C"}
        };
        System.out.println(firstInvalidRecord(deliveries));
    }
}