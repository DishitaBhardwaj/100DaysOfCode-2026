//Need to rebuild one valid array from the shuffled pair minimums

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n = 3;
    vector<int> b = {4, 2, 2};

    sort(b.begin(), b.end());

    vector<int> a;

    int index = 0;

    // each value appears n-i-1 times as the minimum
    for (int i = 0; i < n - 1; i++)
    {
        a.push_back(b[index]);
        index += (n - i - 1);
    }

    // last element can be any large value
    a.push_back(1000000000);

    for (int x : a)
    {
        cout << x << " ";
    }

    return 0;
}