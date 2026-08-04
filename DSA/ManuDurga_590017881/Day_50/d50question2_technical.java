package Day_50;

import java.util.*;

public class d50question2_technical {
    public static int lastRockWeight(int[] rocks) {
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
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i] = sc.nextInt();}

        System.out.println(lastRockWeight(Arr1));
        sc.close();}}
