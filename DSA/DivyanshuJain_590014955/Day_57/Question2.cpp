#include <iostream>
#include <vector>
using namespace std;

bool isMirror(vector<long long>& a, vector<long long>& b, int i, int j) {

    // Both indices are outside their arrays
    if (i >= a.size() && j >= b.size())
        return true;

    // Only one index is outside
    if (i >= a.size() || j >= b.size())
        return false;

    // Both nodes are missing
    if (a[i] == -1 && b[j] == -1)
        return true;

    // One node is missing
    if (a[i] == -1 || b[j] == -1)
        return false;

    // Values don't match
    if (a[i] != b[j])
        return false;

    // Left of A ↔ Right of B
    // Right of A ↔ Left of B
    return isMirror(a, b, 2 * i + 1, 2 * j + 2) &&
           isMirror(a, b, 2 * i + 2, 2 * j + 1);
}

int main() {

    int t;
    cin >> t;

    while (t--) {

        int n1;
        cin >> n1;

        vector<long long> warehouse1(n1);

        for (int i = 0; i < n1; i++) {
            cin >> warehouse1[i];
        }

        int n2;
        cin >> n2;

        vector<long long> warehouse2(n2);

        for (int i = 0; i < n2; i++) {
            cin >> warehouse2[i];
        }

        if (isMirror(warehouse1, warehouse2, 0, 0))
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}