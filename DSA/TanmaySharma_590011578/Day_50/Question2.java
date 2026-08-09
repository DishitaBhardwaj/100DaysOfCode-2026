package DSA.TanmaySharma_590011578.Day_50;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question2 {
    public static int lastRockWeight(int[] rocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks) {
            pq.offer(rock);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rocks = new int[n];

        for (int i = 0; i < n; i++) {
            rocks[i] = sc.nextInt();
        }

        System.out.println(lastRockWeight(rocks));

        sc.close();
    }
}