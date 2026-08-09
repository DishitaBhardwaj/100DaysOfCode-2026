class Solution {
    public int[] intersection(int[] a, int[] b) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> r = new HashSet<>();
        for (int x : a) s.add(x);
        for (int x : b) if (s.contains(x)) r.add(x);
        int[] c = new int[r.size()];
        int i = 0;
        for (int x : r) c[i++] = x;
        return c;
    }
}