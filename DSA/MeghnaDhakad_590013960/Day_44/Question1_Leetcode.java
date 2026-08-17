class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = arr[0], max = arr[0];

        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if ((max - min) % (n - 1) != 0)
            return false;

        int d = (max - min) / (n - 1);

        if (d == 0)
            return true;

        boolean[] seen = new boolean[n];

        for (int x : arr) {
            int diff = x - min;

            if (diff % d != 0)
                return false;

            int pos = diff / d;

            if (pos >= n || seen[pos])
                return false;

            seen[pos] = true;
        }

        return true;
    }
}