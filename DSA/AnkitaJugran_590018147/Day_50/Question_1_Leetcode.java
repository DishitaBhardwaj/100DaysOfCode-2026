class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        while( k > 0 ){

            int min_index = 0;

            for( int i = 0 ; i < nums.length ; i++ ){

            if( nums[i] < nums[min_index] ){
                min_index = i;
                }
            }

            nums[min_index] *= multiplier;
            k--;

        }
        return nums;
 
    }
}