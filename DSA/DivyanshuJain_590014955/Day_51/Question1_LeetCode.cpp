// Most Frequent Even Element
// (LeetCode #2404)

#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        int ans = -1;
        unordered_map<int,int>mp;
        for(int i=0;i<nums.size();i++){
            if(nums[i]%2==0){
                 mp[nums[i]]++;
            }
        }
        int maxFreq=0;
        for(auto x: mp){
            if(x.second>maxFreq){
                maxFreq = x.second;
                ans = x.first;
            }
            else if(x.second == maxFreq) ans = min(ans,x.first);
        }
        return ans;
    }
};