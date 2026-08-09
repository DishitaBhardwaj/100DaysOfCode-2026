import java.util.*;
public class Question2 
{
    static class Song 
    {
        long length;
        long beauty;
        Song(long length, long beauty) 
        {
            this.length = length;
            this.beauty = beauty;
        }
    }

    public static long maxPlaylistPleasure(long[] length, long[] beauty, int k) 
    {

        int n = length.length;
        Song[] songs = new Song[n];

        for (int i = 0; i < n; i++) 
        {
            songs[i] = new Song(length[i], beauty[i]);
        }

        Arrays.sort(songs, (a, b) -> Long.compare(b.beauty, a.beauty));
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        long sumLengths = 0;
        long maxPleasure = 0;

        for (Song song : songs) 
        {
            minHeap.offer(song.length);
            sumLengths += song.length;
            if (minHeap.size() > k) 
            {
                sumLengths -= minHeap.poll();
            }

            long pleasure = sumLengths * song.beauty;
            maxPleasure = Math.max(maxPleasure, pleasure);
        }

        return maxPleasure;
    }

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] length = new long[n];
        long[] beauty = new long[n];

        for (int i = 0; i < n; i++) 
        {
            length[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) 
        {
            beauty[i] = sc.nextLong();
        }

        int k = sc.nextInt();
        System.out.println(maxPlaylistPleasure(length, beauty, k));

        sc.close();
    }
}