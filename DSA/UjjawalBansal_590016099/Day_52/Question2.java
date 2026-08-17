import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Question2 {
    public static List<String> userRegistrationSystem(String[] requests) {
        Map<String, Integer> data = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (String request : requests) {
            if (!data.containsKey(request)) {
                data.put(request, 1);
                results.add("OK");
            }
            else {
                int suff = data.get(request);
                String newUsername = request + suff;

                while (data.containsKey(newUsername)) {
                    suff++;
                    newUsername = request + suff;
                }
                
                data.put(request, suff + 1);
                data.put(newUsername, 1);
                
                results.add(newUsername);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String[] requests1 = {"abacaba", "acaba", "abacaba", "acab"};
        System.out.println("Output for sample input: ");
        List<String> output1 = userRegistrationSystem(requests1);
        for (String res : output1) {
            System.out.println(res);
        }
    }
}