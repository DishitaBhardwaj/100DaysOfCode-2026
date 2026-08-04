class Solution {
public:
    vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
        while(k--) {
            int index = 0;
            for(int i = 1; i < nums.size(); i++) {
                if(nums[i] < nums[index])
                    index = i;
            }
            nums[index] *= multiplier;
        }
        return nums;
    }
};
