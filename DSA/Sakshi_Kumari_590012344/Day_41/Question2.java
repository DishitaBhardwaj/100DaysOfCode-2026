import java.util.*;

class Solution {
    public String printerWars(String jobs) {

        Queue<Integer> deptA = new LinkedList<>();
        Queue<Integer> deptB = new LinkedList<>();

        int n = jobs.length();

        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'A') {
                deptA.offer(i);
            } else {
                deptB.offer(i);
            }
        }

        while (!deptA.isEmpty() && !deptB.isEmpty()) {

            int a = deptA.poll();
            int b = deptB.poll();

            if (a < b) {
                deptA.offer(a + n);
            } else {
                deptB.offer(b + n);
            }
        }

        if (deptA.isEmpty()) {
            return "Department B";
        }

        return "Department A";
    }
}
