#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int kthSmallest(vector<int>& A, vector<int>& B, int k) {
    if(A.size() > B.size())
        return kthSmallest(B, A, k);
    int n = A.size();
    int m = B.size();
    int left = max(0, k - m);
    int right = min(k, n);
    while(left <= right) {
        int cutA = (left + right) / 2;
        int cutB = k - cutA;
        int leftA = (cutA == 0) ? INT_MIN : A[cutA - 1];
        int leftB = (cutB == 0) ? INT_MIN : B[cutB - 1];
        int rightA = (cutA == n) ? INT_MAX : A[cutA];
        int rightB = (cutB == m) ? INT_MAX : B[cutB];
        if(leftA <= rightB && leftB <= rightA)
            return max(leftA, leftB);
        if(leftA > rightB)
            right = cutA - 1;
        else
            left = cutA + 1;
    }
    return -1;
}

int main() {
    int n, m;
    cout << "Enter the size of first array: ";
    cin >> n;
    vector<int> A(n);
    cout << "Enter the first sorted array: ";
    for(int i = 0; i < n; i++)
        cin >> A[i];
    cout << "Enter the size of second array: ";
    cin >> m;
    vector<int> B(m);
    cout << "Enter the second sorted array: ";
    for(int i = 0; i < m; i++)
        cin >> B[i];
    int k;
    cout << "Enter the value of k: ";
    cin >> k;
    cout << "K-th Smallest Element: "
         << kthSmallest(A, B, k);
    return 0;
}
