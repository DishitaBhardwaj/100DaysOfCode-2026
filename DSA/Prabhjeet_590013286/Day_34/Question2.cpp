//Need to find the maximum number of visible people

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main()
{
    vector<int> arr = {6, 2, 5, 4, 5, 1, 6};
    int n = arr.size();

    vector<int> left(n), right(n);
    stack<int> st;

    // count visible people on the left
    for (int i = 0; i < n; i++)
    {
        while (!st.empty() && arr[st.top()] < arr[i])
        {
            st.pop();
        }

        left[i] = st.size();

        st.push(i);
    }

    while (!st.empty())
        st.pop();

    // count visible people on the right
    for (int i = n - 1; i >= 0; i--)
    {
        while (!st.empty() && arr[st.top()] < arr[i])
        {
            st.pop();
        }

        right[i] = st.size();

        st.push(i);
    }

    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        ans = max(ans, left[i] + right[i] + 1);
    }

    cout << ans;

    return 0;
}