import java.util.*;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) 
        {
            maxHeap.add(sc.nextInt());
        }

        while (maxHeap.size() > 1) 
        {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();
            if (heaviest != secondHeaviest) 
            {
                maxHeap.add(heaviest - secondHeaviest);
            }
        }
        System.out.println(maxHeap.isEmpty() ? 0 : maxHeap.peek());

        sc.close();
    }
}