#include<iostream>
using namespace std;
class Solution {
public:
    long long maxPleasure(vector<int>& length, vector<int>& beauty, int k) {
        vector<pair<int,int>>songs;
        
        for(int i=0;i<length.size();i++){
            songs.push_back({beauty[i],length[i]});
        }
        
        sort(songs.rbegin(),songs.rend());
        
        priority_queue<int,vector<int>,greater<int>>pq;
        
        long long sum = 0;
        long long ans = 0;
        
        for(int i=0;i<songs.size();i++){
            int b = songs[i].first;
            int l = songs[i].second;
            
            pq.push(l);
            sum += l;
            
            if(pq.size()>k){
                sum -= pq.top();
                pq.pop();
            }
            
            ans = max(ans,sum*b);
        }
        
        return ans;
    }
};