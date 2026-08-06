#include<string>
#include<unordered_map>
using namespace std;
class Solution {
public:
    bool areOccurrencesEqual(string s) {
        unordered_map<char,int>mp;
        for(int i=0;i<s.size();i++){
            mp[s[i]]++;
        }
        int y = mp[s[0]];
        for(auto x : mp){
            if(x.second!=y) return false;
        }
        return true;
    }
};