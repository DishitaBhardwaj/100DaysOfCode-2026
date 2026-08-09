class Solution {
    public String favoriteNumber(int[] arr, int k, int x) {
        int greater = 0;
        int equal = 0;

        for (int num : arr) {
            if (num > x) greater++;
            else if (num == x) equal++;
        }

        if (greater >= k) return "NEVER";
        else if (greater + equal <= k) return "ALWAYS";
        else return "MAYBE";
    }
}