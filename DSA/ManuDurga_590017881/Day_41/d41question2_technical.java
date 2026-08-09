package Day_41;

import java.util.*;

public class d41question2_technical {
    private static Map<Character, String> dept = new HashMap<>();

    static {
        dept.put('S', "Sales");
        dept.put('M', "Marketing");
        dept.put('H', "HR");
        dept.put('F', "Finance");
        dept.put('I', "IT");
        dept.put('A', "Admin");
    }

    public static String lastRemainingDepartment(String jobs) {
        Queue<Character> q = new LinkedList<>();
        for (char c : jobs.toCharArray()) q.offer(c);

        while (q.size() > 1) {
            q.offer(q.poll());
            q.poll();
        }

        char win = q.poll();
        return dept.getOrDefault(win, String.valueOf(win));
    }

    public static void main(String[] args) {
        System.out.println(lastRemainingDepartment("SMHFAI"));
        System.out.println(lastRemainingDepartment("SSMMHH"));
        System.out.println(lastRemainingDepartment("IAF"));
    }
}
