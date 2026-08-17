#include <string>
#include <queue>
using namespace std;

class Solution {
public:
    string predictPartyVictory(string jobs) {
        int n = jobs.size();
        queue<int> sales, marketing;
        
        for (int i = 0; i < n; i++) {
            if (jobs[i] == 'S') sales.push(i);
            else marketing.push(i);
        }
        
        while (!sales.empty() && !marketing.empty()) {
            int sIdx = sales.front(); sales.pop();
            int mIdx = marketing.front(); marketing.pop();
            
            if (sIdx < mIdx) {
                sales.push(sIdx + n);
            } else {
                marketing.push(mIdx + n);
            }
        }
        
        return sales.empty() ? "Marketing" : "Sales";
    }
};