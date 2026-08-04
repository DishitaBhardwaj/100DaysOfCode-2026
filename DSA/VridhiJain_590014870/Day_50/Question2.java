import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int lastStoneWeight(int[] rocks) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int rock : rocks) {
            list.add(rock);
        }

        while (list.size() > 1) {

            list.sort(null);

            int y = list.remove(list.size() - 1);
            int x = list.remove(list.size() - 1);

            if (y != x) {
                list.add(y - x);
            }
        }

        if (list.isEmpty()) {
            return 0;
        }

        return list.get(0);
    }
}