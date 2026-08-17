#include <iostream>
#include <queue>
#include <string>
using namespace std;

string winner(string jobs) {
    int n = jobs.size();
    queue<int> S, M;

    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            S.push(i);
        else
            M.push(i);
    }

    while (!S.empty() && !M.empty()) {
        int s = S.front(); S.pop();
        int m = M.front(); M.pop();

        if (s < m)
            S.push(s + n);
        else
            M.push(m + n);
    }

    return S.empty() ? "Marketing" : "Sales";
}

int main() {
    string jobs = "SMM";

    cout << winner(jobs);

    return 0;
}