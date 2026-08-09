//Need to find the maximum temperature in every window

#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int main()
{
    vector<int> temperatures = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    deque<int> dq;
    vector<int> ans;

    for (int i = 0; i < temperatures.size(); i++)
    {
        // remove indices that are outside the current window
        while (!dq.empty() && dq.front() <= i - k)
        {
            dq.pop_front();
        }

        // remove smaller values since they can't be maximum
        while (!dq.empty() && temperatures[dq.back()] <= temperatures[i])
        {
            dq.pop_back();
        }

        dq.push_back(i);

        if (i >= k - 1)
        {
            ans.push_back(temperatures[dq.front()]);
        }
    }

    for (int x : ans)
    {
        cout << x << " ";
    }

    return 0;
}