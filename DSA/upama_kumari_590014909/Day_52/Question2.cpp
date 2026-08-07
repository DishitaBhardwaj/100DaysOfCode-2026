#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    int n;
    cin >> n;

    unordered_map<string, int> mp;

    while (n--) {
        string username;
        cin >> username;

        if (mp.find(username) == mp.end()) {
            cout << "OK" << endl;
            mp[username] = 1;
        }
        else {
            cout << username << mp[username] << endl;

            mp[username]++;

            mp[username + to_string(mp[username] - 1)] = 1;
        }
    }

    return 0;
}