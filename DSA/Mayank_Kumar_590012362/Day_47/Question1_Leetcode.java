class Solution {
    public String[] findRelativeRanks(int[] a) {
        int n = a.length;
        Integer[] i = new Integer[n];
        for (int j = 0; j < n; j++) i[j] = j;
        Arrays.sort(i, (x, y) -> Integer.compare(a[y], a[x]));
        String[] r = new String[n];
        for (int j = 0; j < n; j++) {
            if (j == 0) r[i[j]] = "Gold Medal";
            else if (j == 1) r[i[j]] = "Silver Medal";
            else if (j == 2) r[i[j]] = "Bronze Medal";
            else r[i[j]] = Integer.toString(j + 1);
        } return r;
    }
}