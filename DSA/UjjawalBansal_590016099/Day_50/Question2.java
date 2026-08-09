import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class Question2 {
    public static int theQuarrySmasher(int[] rocks) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int rock : rocks) {
            maxHeap.offer(rock);
        }
        
        while (maxHeap.size() > 1) {
            int h1 = maxHeap.poll();
            int h2 = maxHeap.poll();
            
            if (h1 != h2) {
                maxHeap.offer(h1 - h2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of rocks: ");
        int n = sc.nextInt();
            
        int[] rocks = new int[n];
        System.out.println("Enter the weights of the " + n + " rocks:");
        for (int i = 0; i < n; i++) {
            rocks[i] = sc.nextInt();
        }
            
        System.out.println("\nInitial rocks: " + Arrays.toString(rocks));
        int ans = theQuarrySmasher(rocks);
        System.out.println("Weight of the last remaining rock: " + ans);
        sc.close();
    }
}