import java.util.*;

public class Question1_Leetcode {

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        int[] sorted = score.clone();
        Arrays.sort(sorted);

        HashMap<Integer, String> map = new HashMap<>();

        int rank = 1;

        for (int i = n - 1; i >= 0; i--) {

            if (rank == 1) {
                map.put(sorted[i], "Gold Medal");
            } else if (rank == 2) {
                map.put(sorted[i], "Silver Medal");
            } else if (rank == 3) {
                map.put(sorted[i], "Bronze Medal");
            } else {
                map.put(sorted[i], String.valueOf(rank));
            }

            rank++;
        }

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(score[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        String[] ans = findRelativeRanks(score);

        System.out.print("[");

        for (int i = 0; i < ans.length; i++) {
            System.out.print("\"" + ans[i] + "\"");

            if (i != ans.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}