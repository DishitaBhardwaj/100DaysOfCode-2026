//Need to simulate the printer war using two queues

#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main()
{
    string jobs = "SMM";

    queue<int> sales;
    queue<int> marketing;

    int n = jobs.size();

    for (int i = 0; i < n; i++)
    {
        if (jobs[i] == 'S')
        {
            sales.push(i);
        }
        else
        {
            marketing.push(i);
        }
    }

    while (!sales.empty() && !marketing.empty())
    {
        int s = sales.front();
        sales.pop();

        int m = marketing.front();
        marketing.pop();

        if (s < m)
        {
            sales.push(s + n);
        }
        else
        {
            marketing.push(m + n);
        }
    }

    if (sales.empty())
    {
        cout << "Marketing";
    }
    else
    {
        cout << "Sales";
    }

    return 0;
}