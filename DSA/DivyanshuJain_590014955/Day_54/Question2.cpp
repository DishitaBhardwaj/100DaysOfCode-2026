#include<iostream>
using namespace std;
class Solution {
public:
    string findTheWinner(vector<string>& goals) {
        unordered_map<string,int>mp;
        
        for(int i=0;i<goals.size();i++){
            mp[goals[i]]++;
        }
        
        string ans;
        int mx = 0;
        
        for(auto p : mp){
            if(p.second > mx){
                mx = p.second;
                ans = p.first;
            }
        }
        
        return ans;
    }
};