#include <bits/stdc++.h>
using namespace std;

vector<int> constructArray(int n, vector<int>& b) {
    sort(b.begin(), b.end());

    vector<int> ans;
    int idx = 0;

    for (int i = 0; i < n - 1; i++) {
        ans.push_back(b[idx]);
        idx += (n - 1 - i);
    }

    ans.push_back(1000000000);  

    return ans;
}

int main() {
    int n;
    cin >> n;

    int m = n * (n - 1) / 2;
    vector<int> b(m);

    for (int i = 0; i < m; i++)
        cin >> b[i];

    vector<int> ans = constructArray(n, b);

    for (int x : ans)
        cout << x << " ";

    return 0;
}