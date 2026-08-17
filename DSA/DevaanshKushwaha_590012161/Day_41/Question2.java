import java.util.*;

class Solution {
    public String lastRemainingDepartment(String jobs) {
        // Extend this map with any other department codes you use
        Map<Character, String> deptNames = new HashMap<>();
        deptNames.put('S', "Sales");
        deptNames.put('M', "Marketing");
        deptNames.put('H', "HR");
        deptNames.put('F', "Finance");
        deptNames.put('I', "IT");
        deptNames.put('A', "Admin");

        Queue<Character> queue = new LinkedList<>();
        for (char c : jobs.toCharArray()) {
            queue.offer(c);
        }

        while (queue.size() > 1) {
            queue.offer(queue.poll()); // pass front to back (survives)
            queue.poll();              // eliminate new front
        }

        char winner = queue.poll();
        return deptNames.getOrDefault(winner, String.valueOf(winner));
    }
}
