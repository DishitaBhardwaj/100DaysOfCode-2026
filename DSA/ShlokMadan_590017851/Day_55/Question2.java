import java.util.*;
public class Question2 
{
    public static long maxPleasure(int[] length, int[] beauty, int k) 
    {
        int n = length.length;
        Integer[] index = new Integer[n];
        for(int i = 0; i < n; i++) 
            {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> beauty[b] - beauty[a]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; i++) 
            {
            int idx = index[i];
            pq.add(length[idx]);
            sum += length[idx];
            if(pq.size() > k) 
                {
                sum -= pq.poll();
            }
            ans = Math.max(ans, sum * beauty[idx]);
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] length = {4, 15, 3, 6};
        int[] beauty = {7, 1, 6, 8};
        int k = 3;
        System.out.println(maxPleasure(length, beauty, k));
    }
}