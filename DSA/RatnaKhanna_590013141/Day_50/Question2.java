import java.util.*;

public class Main {
    public static int lastStoneWeight(int[] rocks) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks) {
            maxHeap.offer(rock);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rocks = new int[n];

        for (int i = 0; i < n; i++) {
            rocks[i] = sc.nextInt();
        }

        System.out.println(lastStoneWeight(rocks));

        sc.close();
    }
}
