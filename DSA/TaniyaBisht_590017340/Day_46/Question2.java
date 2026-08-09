
import java.util.*;
class PDS{
    public static int maxPrefixDifferenceScore(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left != right)
                list.add(arr[right--]);
            else
                list.add(arr[right--]);

            if (left <= right)
                list.add(arr[left++]);
        }
        int max = list.get(0);
        int min = list.get(0);
        int score = 0;
        for (int num : list) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            score += (max - min);
        }
        System.out.println("Rearranged Array:" + list);
        return score;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int ans = maxPrefixDifferenceScore(arr);
        System.out.println("Maximum Prefix Difference Score:" + ans);
    }
}
