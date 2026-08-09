import java.util.*;
public class Question2 
{
    public static void register(String[] requests) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : requests) 
            {
            if(!map.containsKey(name)) 
                {
                System.out.println("OK");
                map.put(name, 1);
            }
            else 
                {
                int num = map.get(name);
                String newName = name + num;
                while(map.containsKey(newName)) 
                    {
                    num++;
                    newName = name + num;
                }
                System.out.println(newName);
                map.put(name, num + 1);
                map.put(newName, 1);
            }
        }
    }
    public static void main(String[] args) 
    {
        String[] requests = {
            "abacaba",
            "acaba",
            "abacaba",
            "acab"
        };
        register(requests);
    }
}