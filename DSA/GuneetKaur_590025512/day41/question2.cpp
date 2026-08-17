#include <bits/stdc++.h>
using namespace std;

string officePrinterWars(string jobs) {

    queue<int> sales, marketing;
    int n = jobs.size();
    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            sales.push(i);
        else
            marketing.push(i);
    }
    while (!sales.empty() && !marketing.empty()) {

        int s = sales.front();
        int m = marketing.front();

        sales.pop();
        marketing.pop();

        if (s < m) {
            sales.push(s + n);
        }
        else {
            marketing.push(m + n);
        }
    }

    return sales.empty() ? "Marketing" : "Sales";
}

int main() {

    cout << officePrinterWars("SM") << endl;
    cout << officePrinterWars("SMM") << endl;
    cout << officePrinterWars("MSS") << endl;

    return 0;
}