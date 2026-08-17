import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        // Add people 1 to n
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int minute = 0;

        while (!q.isEmpty()) {

            int person = q.remove();
            minute++;

            if (person == k) {
                System.out.println(minute);
                break;
            }

            if (!q.isEmpty() && q.peek() % 2 == 1) {
                int oddPerson = q.remove();
                q.add(oddPerson);
            }
        }
    }
}