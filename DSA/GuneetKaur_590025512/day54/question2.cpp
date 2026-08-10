#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

class solution{
    public:
    string  match(vector<string > &teams)
    {
        unordered_map<string,int>mp;
        for(  string team :teams)
        {
            mp[team]++;
        }
       string winner = "";
        int maxGoals = 0;

        for (auto it : mp) {
            if (it.second > maxGoals) {
                maxGoals = it.second;
                winner = it.first;
            }
        }

        return winner;
    }
};