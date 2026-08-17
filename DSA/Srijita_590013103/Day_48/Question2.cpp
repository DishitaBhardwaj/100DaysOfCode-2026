#include <bits/stdc++.h>
using namespace std;

vector<long long> constructArray(int n, vector<long long>& b) {
    sort(b.begin(), b.end());

    vector<long long> a;
    int idx = 0;

    for (int i = 0; i < n - 1; i++) {
        a.push_back(b[idx]);
        idx += (n - i - 1);
    }

    a.push_back(1000000000LL);

    return a;
}