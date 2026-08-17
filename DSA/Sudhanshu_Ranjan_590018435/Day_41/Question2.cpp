#include <string>
#include <queue>
using namespace std;

string remainingDepartment(string jobs) {
    int n = jobs.size();
    queue<int> sales, marketing;

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

        if (s < m)
            sales.push(s + n);
        else
            marketing.push(m + n);
    }

    return sales.empty() ? "Marketing" : "Sales";
}