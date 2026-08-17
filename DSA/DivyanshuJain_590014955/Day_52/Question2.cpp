#include<iostream>
#include<unordered_map>
using namespace std;

int main() {
    int n;
    cin >> n;

    unordered_map<string, int> mp;

    while (n--) {
        string s;
        cin >> s;

        if (mp.find(s) == mp.end()) {
            cout << "OK\n";
            mp[s] = 1;
        } else {
            string temp = s + to_string(mp[s]);
            cout << temp << "\n";

            mp[s]++;
            mp[temp] = 1;
        }
    }

    return 0;
}