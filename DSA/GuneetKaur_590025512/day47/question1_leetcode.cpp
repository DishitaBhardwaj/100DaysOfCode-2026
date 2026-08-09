#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<string> Ranks(vector<int>& score) {
        vector<int> sorted = score;
        sort(sorted.begin(), sorted.end(), greater<int>());

        unordered_map<int, string> rank;

        for (int i = 0; i < sorted.size(); i++) {
            if (i == 0)
                rank[sorted[i]] = "Gold Medal";
            else if (i == 1)
                rank[sorted[i]] = "Silver Medal";
            else if (i == 2)
                rank[sorted[i]] = "Bronze Medal";
            else
                rank[sorted[i]] = to_string(i + 1);
        }

        vector<string> ans;
        for (int s : score) {
            ans.push_back(rank[s]);
        }

        return ans;
    }
};

