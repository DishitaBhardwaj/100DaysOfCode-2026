#include <iostream>
#include <vector>
using namespace std;

vector<int> reconstructArray(int n, vector<int>& b) {
    vector<int> a;
    int idx = 0;

    for (int i = 0; i < n - 1; i++) {
        a.push_back(b[idx]);
        idx += (n - i - 1);
    }

    a.push_back(1000000000);

    return a;
}

int main() {
    int n;
    cin >> n;

    int m = n * (n - 1) / 2;
    vector<int> b(m);

    for (int i = 0; i < m; i++)
        cin >> b[i];

    vector<int> ans = reconstructArray(n, b);

    for (int x : ans)
        cout << x << " ";

    return 0;
}
