#include <bits/stdc++.h>
using namespace std;

vector<string> registerUsers(vector<string>& requests) {
    unordered_map<string, int> mp;
    vector<string> ans;

    for (string name : requests) {
        if (mp.find(name) == mp.end()) {
            ans.push_back("OK");
            mp[name] = 1;
        } else {
            string newName = name + to_string(mp[name]);
            ans.push_back(newName);

            mp[name]++;
            mp[newName] = 1;
        }
    }

    return ans;
}

int main() {
    vector<string> requests = {"john", "john", "john", "john"};

    vector<string> ans = registerUsers(requests);

    for (string s : ans)
        cout << s << "\n";

    return 0;
}