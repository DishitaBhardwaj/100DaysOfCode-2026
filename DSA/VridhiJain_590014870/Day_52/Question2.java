import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        String[] users = {"abacaba", "acaba", "abacaba", "acab"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : users) {

           
            if (!map.containsKey(name)) {
                System.out.println("OK");
                map.put(name, 1);
            }
           
            else {
                int number = map.get(name);

                System.out.println(name + number);

                map.put(name, number + 1);
            }
        }
    }
}