import java.util.*;

public class Question2 {
    public static long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(beauty[b], beauty[a]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0;
        long best = 0;

        for (int i : order) {
            sum += length[i];
            heap.offer(length[i]);
            if (heap.size() > k) {
                sum -= heap.poll();
            }
            long pleasure = sum * beauty[i];
            best = Math.max(best, pleasure);
        }
        return best;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();

        int[] length = new int[n];
        int[] beauty = new int[n];

        System.out.println("Enter length values:");
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        System.out.println("Enter beauty values:");
        for (int i = 0; i < n; i++) {
            beauty[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();
        
        long answer = maxPleasure(length, beauty, k);

        System.out.println("length = " + Arrays.toString(length));
        System.out.println("beauty = " + Arrays.toString(beauty));
        System.out.println("k = " + k);
        System.out.println("Maximum pleasure = " + answer);

        sc.close();
    }
}