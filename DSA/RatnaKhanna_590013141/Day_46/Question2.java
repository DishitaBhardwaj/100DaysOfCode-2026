import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();

        int left = 0, right = n - 1;

        while (left <= right) {
            list.add(arr[right--]);      
            if (left <= right) {
                list.add(arr[left++]);   
            }
        }

        int max = list.get(0);
        int min = list.get(0);
        long score = 0;

        for (int num : list) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            score += (max - min);
        }

        System.out.println(score);

        sc.close();
    }
}
