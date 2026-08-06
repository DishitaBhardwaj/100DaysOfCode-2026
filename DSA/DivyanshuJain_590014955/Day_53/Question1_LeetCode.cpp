#include<iostream>
#include<string>
using namespace std;

class Solution {
public:
    int countGoodSubstrings(string s) {
        int count=0;
        for(int i=0;i<(int)s.size()-2;i++){
            if(s[i]!=s[i+1] and s[i+1]!=s[i+2] and s[i]!=s[i+2]) count++;
        }
        return count;
    }
};