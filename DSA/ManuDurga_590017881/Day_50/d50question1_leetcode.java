package Day_50;

import java.util.*;

public class d50question1_leetcode {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] curr = pq.poll();
            int value = curr[0];
            int index = curr[1];

            value *= multiplier;
            nums[index] = value;

            pq.offer(new int[]{value, index});
        }

        return nums;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        int[] Arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            System.out.print(": ");
            Arr1[i]=sc.nextInt();}
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.print("Enter Multiplier: ");
        int mult = sc.nextInt();
            System.out.println(Arrays.toString(getFinalState(Arr1, k, mult)));
        sc.close();    }}
