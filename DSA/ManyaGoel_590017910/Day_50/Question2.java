import java.util.*;

public class Question2 {
    public static int lastRemainingRock(int[] rocks) {
        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
        for (int rock : rocks) {
            maxHeap.offer(rock);
        }
        while (maxHeap.size() > 1) {

            int first = maxHeap.remove();
            int second = maxHeap.remove();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rocks: ");
        int n = sc.nextInt();
        int[] rocks = new int[n];
        System.out.print("Enter the weights of the rocks: ");
        for (int i = 0; i < n; i++) {
            rocks[i] = sc.nextInt();
        }
        System.out.println("Rocks: " + Arrays.toString(rocks));
        System.out.println("Weight of the last remaining rock: "+ lastRemainingRock(rocks));
        sc.close();
    }
}