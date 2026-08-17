class Solution {
    public int mostFrequentEven(int[] arr) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int m = 0, r = -1;
        for (int a : arr) {
            if (a % 2 != 0) continue;
            int c = f.getOrDefault(a, 0) + 1;
            f.put(a, c);
            if (c > m || (c == m && (r == -1 || a < r))) { m = c; r = a; }
        }
        return r;
    }
}