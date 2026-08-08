#include<iostream>
using namespace std;
class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        unordered_map<int,int>mp;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
        }
        int mx = INT_MIN;
        for(int i=0;i<nums.size();i++){
            if(mp[nums[i]]>mx) mx = mp[nums[i]];
        }
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(mp[nums[i]]==mx) count++; 
        }
        return count;
    }
};