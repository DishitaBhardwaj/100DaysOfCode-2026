
#include<vector>
#include<iostream>
#include<unordered_map>
using namespace std;

class Solution {
public:
    int receivingLogValidation(vector<vector<string>>& deliveries) {
        unordered_map<string, string> mp;

        for (int i = 0; i < deliveries.size(); i++) {
            string vendor = deliveries[i][0];
            string lot = deliveries[i][1];
            string cert = deliveries[i][2];

            
            string key = vendor + "#" + lot;

            if (mp.find(key) == mp.end()) {
             
                mp[key] = cert;
            } else {
                
                if (mp[key] != cert) {
                    return i;
                }
            }
        }

        return -1;
    }
};