#include<iostream>
using namespace std;

class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        vector<int>ans;
        vector<int>idx;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        
        for(int i=0;i<nums.size();i++){
            pq.push({nums[i],i});
            
            if(pq.size()>k){
                pq.pop();
            }
        }
        
        while(k>0){
            pair<int,int>p = pq.top();
            pq.pop();
            idx.push_back(p.second);
            k--;
        }
        
        sort(idx.begin(),idx.end());
        
        for(int i=0;i<idx.size();i++){
            ans.push_back(nums[idx[i]]);
        }
        
        return ans;
    }
};