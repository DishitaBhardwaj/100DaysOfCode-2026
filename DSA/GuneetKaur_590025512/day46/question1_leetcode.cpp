
#include<iostream>
#include<vector>
#include<unordered_set>
using namespace std ;
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> s;
        vector<int> ans;

        // Store unique elements of nums1
        for (int num : nums1) {
            s.insert(num);
        }

        // Check elements of nums2
        for (int num : nums2) {
            if (s.find(num) != s.end()) {
                ans.push_back(num);
                s.erase(num);   // Prevent duplicates in the answer
            }
        }

        return ans;
    }
};