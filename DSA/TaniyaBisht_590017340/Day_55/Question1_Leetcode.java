
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] numwithIndex = new int[n][2];
        for(int i=0; i<n; i++){
            numwithIndex[i][0] = nums[i];
            numwithIndex[i][1] = i;
        }
        Arrays.sort(numwithIndex, (a, b) -> b[0] - a[0]);
        int[][] topk = Arrays.copyOfRange(numwithIndex, 0, k);
        Arrays.sort(topk, Comparator.comparingInt(a -> a[1]));
        int[] r= new int[k];
        for(int i=0; i<k; i++){
            r[i] = topk[i][0];
        }
        return r;
    }
}