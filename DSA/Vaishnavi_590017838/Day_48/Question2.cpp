#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<long long> constructArray(int n, vector<long long>& b) {
    sort(b.begin(), b.end());
    vector<long long> answer;
    int index = 0;
    for(int remaining = n - 1; remaining >= 1; remaining--) {
        answer.push_back(b[index]);
        index += remaining;
    }
    answer.push_back(1000000000);
    return answer;
}

int main() {
    int n;
    cout << "Enter the size of the original array: ";
    cin >> n;
    int size = n * (n - 1) / 2;
    vector<long long> b(size);
    cout << "Enter the elements of array b: ";
    for(int i = 0; i < size; i++) {
        cin >> b[i];
    }
    vector<long long> result = constructArray(n, b);
    cout << "One possible original array:\n";
    for(long long value : result)
        cout << value << " ";
    return 0;
}
