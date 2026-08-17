class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
       
        while(k>0){
             int idx=0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[idx]){
                idx=i;
            }
        }
        nums[idx]=nums[idx]*multiplier;
        k--;
        }
        return nums;

    }
}