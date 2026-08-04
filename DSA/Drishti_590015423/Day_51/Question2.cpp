#include <bits/stdc++.h>
using namespace std;

int firstInvalidRecord(vector<vector<int>>& records) {
    map<pair<int, int>, int> mp;

    for (int i = 0; i < records.size(); i++) {
        int vendor = records[i][0];
        int lot = records[i][1];
        int cert = records[i][2];

        pair<int, int> key = {vendor, lot};

        if (mp.find(key) == mp.end()) {
            mp[key] = cert;
        } else {
            if (mp[key] != cert)
                return i;
        }
    }

    return -1;
}

int main() {
    vector<vector<int>> records = {
        {1, 101, 500},
        {2, 201, 700},
        {1, 101, 500},
        {2, 201, 800}, // Conflict
        {3, 301, 900}
    };

    cout << firstInvalidRecord(records);
    return 0;
}
