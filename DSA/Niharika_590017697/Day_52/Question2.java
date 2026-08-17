import java.util.*;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] requests = new String[n];
        for (int i = 0; i < n; i++) 
        {
            requests[i] = sc.next();
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String username : requests) 
        {
            if (!map.containsKey(username)) 
            {
                System.out.println("OK");
                map.put(username, 1);
            } 
            else 
            {
                int num = map.get(username);
                String newUsername = username + num;

                while (map.containsKey(newUsername)) 
                {
                    num++;
                    newUsername = username + num;
                }

                System.out.println(newUsername);
                map.put(username, num + 1);
                map.put(newUsername, 1);
            }
        }
        sc.close();
    }
}