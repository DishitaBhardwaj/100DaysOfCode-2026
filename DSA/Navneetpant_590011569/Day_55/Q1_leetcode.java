class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int [][] arr = new int [nums.length][2];

        for (int i = 0 ; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }


        Arrays.sort(arr, (a,b) -> Integer.compare(b[0],a[0]));


        int [][] top = new int [k][1];
        for ( int i = 0 ; i < k ; i++ ) {
            top[i] = arr[i];
        }


        Arrays.sort(top,(a,b) -> Integer.compare(a[1],b[1]));


        int [] ans = new int [k];
        for (int i = 0 ; i < k ; i++) {
            ans[i] = top[i][0];
        }

        return ans;


    
    }
}