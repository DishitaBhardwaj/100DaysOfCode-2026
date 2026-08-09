class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> first(nums1.begin(), nums1.end());
        unordered_set<int> result;
        for(int value : nums2) {
            if(first.count(value))
                result.insert(value);
        }
        return vector<int>(result.begin(), result.end());
    }
};
