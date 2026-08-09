#include <iostream>
#include <queue>
#include <string>
using namespace std;

string winningDepartment(string jobs) {
    queue<int> sales;
    queue<int> marketing;

    int n = jobs.length();
    for(int i = 0; i < n; i++) {
        if(jobs[i] == 'S')
            sales.push(i);
        else
            marketing.push(i);
    }
    while(!sales.empty() && !marketing.empty()) {
        int saleJob = sales.front();
        sales.pop();
        int marketJob = marketing.front();
        marketing.pop();
        if(saleJob < marketJob)
            sales.push(saleJob + n);
        else
            marketing.push(marketJob + n);
    }

    if(sales.empty())
        return "Marketing";
    return "Sales";
}

int main() {
    string jobs;
    cout << "Enter the sequence of jobs (S/M): ";
    cin >> jobs;

    cout << "Department remaining: "
         << winningDepartment(jobs);
    return 0;
}
