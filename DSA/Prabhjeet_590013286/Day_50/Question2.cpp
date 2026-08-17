//Need to keep smashing the two heaviest rocks

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    vector<int> rocks = {2, 7, 4, 1, 8, 1};

    priority_queue<int> pq;

    // max heap always gives the heaviest rock
    for (int x : rocks)
    {
        pq.push(x);
    }

    while (pq.size() > 1)
    {
        int first = pq.top();
        pq.pop();

        int second = pq.top();
        pq.pop();

        // only push back if something remains
        if (first != second)
        {
            pq.push(first - second);
        }
    }

    if (pq.empty())
    {
        cout << 0;
    }
    else
    {
        cout << pq.top();
    }

    return 0;
}