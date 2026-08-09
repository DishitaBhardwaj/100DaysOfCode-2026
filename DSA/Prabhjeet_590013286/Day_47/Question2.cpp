//Need to find the kth smallest from both sorted arrays without merging them

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int kthSmallest(vector<int>& A, vector<int>& B, int k)
{
    // binary search on the smaller array
    if (A.size() > B.size())
        return kthSmallest(B, A, k);

    int n = A.size();
    int m = B.size();

    int low = max(0, k - m);
    int high = min(k, n);

    while (low <= high)
    {
        int cutA = (low + high) / 2;
        int cutB = k - cutA;

        int leftA = (cutA == 0) ? INT_MIN : A[cutA - 1];
        int leftB = (cutB == 0) ? INT_MIN : B[cutB - 1];

        int rightA = (cutA == n) ? INT_MAX : A[cutA];
        int rightB = (cutB == m) ? INT_MAX : B[cutB];

        // found the correct split
        if (leftA <= rightB && leftB <= rightA)
        {
            return max(leftA, leftB);
        }

        if (leftA > rightB)
        {
            high = cutA - 1;
        }
        else
        {
            low = cutA + 1;
        }
    }

    return -1;
}

int main()
{
    vector<int> A = {2, 3, 6, 7};
    vector<int> B = {1, 4, 5, 8};

    int k = 5;

    cout << kthSmallest(A, B, k);

    return 0;
}