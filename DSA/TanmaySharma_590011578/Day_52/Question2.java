package DSA.TanmaySharma_590011578.Day_52;
import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = names[i];

            if (!map.containsKey(name)) {
                map.put(name, 1);
                System.out.println("OK");
            } else {
                int count = map.get(name);
                String newName = name + count;

                while (map.containsKey(newName)) {
                    count++;
                    newName = name + count;
                }

                System.out.println(newName);
                map.put(name, count + 1);
                map.put(newName, 1);
            }
        }

        sc.close();
    }
}
