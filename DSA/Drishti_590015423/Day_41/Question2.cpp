class Solution {
public:
    string predictWinner(string jobs) {
        int n = jobs.size();

        queue<int> sales;
        queue<int> marketing;

        for (int i = 0; i < n; i++) {
            if (jobs[i] == 'S')
                sales.push(i);
            else
                marketing.push(i);
        }

        while (!sales.empty() && !marketing.empty()) {
            int s = sales.front();
            sales.pop();

            int m = marketing.front();
            marketing.pop();

            if (s < m) {
                // Sales acts first
                sales.push(s + n);
            } else {
                // Marketing acts first
                marketing.push(m + n);
            }
        }

        return sales.empty() ? "Marketing" : "Sales";
    }
};
