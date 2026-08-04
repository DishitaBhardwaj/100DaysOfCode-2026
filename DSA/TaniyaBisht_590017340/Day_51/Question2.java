
import java.util.*;
class RLV{
    public static int validateRecords(int[][] records){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            int vendor = records[i][0];
            int lot = records[i][1];
            int cert = records[i][2];
            String key = vendor + "-" + lot;
            if(!map.containsKey(key)){
                map.put(key, cert);
            } 
            else{
                if (map.get(key) != cert){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[][] records = { {101, 5, 200}, {102, 7, 300}, {101, 5, 200}, {101, 5, 500}
        };
        int ans = validateRecords(records);
        System.out.println(ans);
    }
}