
import java.util.*;
class RS{
    public static void registerUsers(String[] users){
        HashMap<String, Integer> map = new HashMap<>();
        for(String user : users){
            if(!map.containsKey(user)){
                System.out.println("OK");
                map.put(user, 1);
            } 
            else{
                int count = map.get(user);
                String newUser = user + count;
                System.out.println(newUser);
                map.put(user, count + 1);
                map.put(newUser, 1);
            }
        }
    }
    public static void main(String[] args){
        String[] users = {"abacaba", "acaba", "abacaba", "acab", "abacaba"
        };
        registerUsers(users);
    }
}