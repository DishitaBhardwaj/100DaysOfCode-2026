class Solution {
public:
    long long maxPrefixScore(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1) return 0;

        int mx = *max_element(nums.begin(), nums.end());
        int mn = *min_element(nums.begin(), nums.end());

        return 1LL * (n - 1) * (mx - mn);
    }
};