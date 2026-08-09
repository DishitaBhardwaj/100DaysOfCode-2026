package Day_52;

import java.util.*;

public class d52question2_technical {
    public static List<String> usernameRegistration(String[] requests) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String username : requests) {

            if (!map.containsKey(username)) {
                result.add("OK");
                map.put(username, 1);
            } else {
                int count = map.get(username);
                String newUsername = username + count;

                while (map.containsKey(newUsername)) {
                    count++;
                    newUsername = username + count;
                }

                result.add(newUsername);

                map.put(username, count + 1);
                map.put(newUsername, 1);
            }
        }

        return result;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        String[]Arr1 = new String[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i] = sc.nextLine();}

        System.out.println(usernameRegistration(Arr1));
        sc.close();}}
