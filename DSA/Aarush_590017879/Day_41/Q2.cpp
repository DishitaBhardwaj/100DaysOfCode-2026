#include <iostream>
#include <queue>
#include <string>
using namespace std;

string officePrinterWars(string jobs) {
    int n = jobs.size();

    queue<int> sales;
    queue<int> marketing;

    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S') {
            sales.push(i);
        }
        else if (jobs[i] == 'M') {
            marketing.push(i);
        }
    }

    while (!sales.empty() && !marketing.empty()) {
        int s = sales.front();
        sales.pop();

        int m = marketing.front();
        marketing.pop();

        if (s < m) {
            sales.push(s + n);
        }
        else {
            marketing.push(m + n);
        }
    }

    if (!sales.empty()) {
        return "Sales";
    }

    return "Marketing";
}

int main() {
    string jobs;

    cout << "Enter jobs: ";
    cin >> jobs;

    cout << officePrinterWars(jobs) << endl;

    return 0;
}