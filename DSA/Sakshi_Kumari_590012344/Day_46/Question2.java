import java.util.*;

class Solution {

    public long maxPrefixDifferenceScore(int[] arr) {
        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            list.add(arr[i]);
            i++;

            if (i <= j) {
                list.add(arr[j]);
                j--;
            }
        }

        int min = list.get(0);
        int max = list.get(0);
        long score = 0;

        for (int num : list) {
            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }

            score += (max - min);
        }

        return score;
    }
}
