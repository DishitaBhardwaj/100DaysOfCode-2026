package DSA.TanmaySharma_590011578.Day_45;
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l=0;
        int k=0;;
        int r=nums.length-1;
        while(l<=r){
             int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid]){
                r=mid-1;
                k=mid;
            }
            else{
                l=mid+1;
                k=mid;
            }
        }
        if(target>nums[k]){
            return k+1;
        }
        return k;
}
}