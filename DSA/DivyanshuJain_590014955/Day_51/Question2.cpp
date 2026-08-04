#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int receivingLogValidation(vector<vector<string>> &deliveries) {
    unordered_map<string, string> mp;

    for (int i = 0; i < deliveries.size(); i++) {
        string key = deliveries[i][0] + "#" + deliveries[i][1];
        string cert = deliveries[i][2];

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
    vector<vector<string>> deliveries = {
        {"V1", "L100", "A"},
        {"V2", "L200", "B"},
        {"V1", "L100", "A"},
        {"V1", "L100", "C"}
    };

    cout << receivingLogValidation(deliveries) << endl;

    return 0;
}