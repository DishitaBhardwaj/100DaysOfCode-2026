package Day_55;

import java.util.*;

public class d55question2_technical {
    public static long maxPleasure(int[] length, int[] beauty, int k) {
        int n = length.length;
        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = beauty[i];
            songs[i][1] = length[i];
        }

        Arrays.sort(songs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0, best = 0;

        for (int[] s : songs) {
            sum += s[1];
            heap.add(s[1]);
            if (heap.size() > k) sum -= heap.poll();
            best = Math.max(best, sum * s[0]);
        }

        return best;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.print("Enter Size of Array: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        int[] Arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            System.out.print(": ");
            Arr2[i]=sc.nextInt();}
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.println(maxPleasure(Arr1,Arr2,k));
        sc.close();}}
