import java.util.*;

class Solution {
    public void userRegistration(String[] name) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String temp : name) {

            if (!hm.containsKey(temp)) {
                System.out.println("OK");
                hm.put(temp, 1);
            } else {
                int count = hm.get(temp);
                String newName = temp + count;

                System.out.println(newName);

                hm.put(temp, count + 1);
                hm.put(newName, 1);
            }
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String[] arr = {"john", "john", "john", "john"};
        obj.userRegistration(arr);
    }
}