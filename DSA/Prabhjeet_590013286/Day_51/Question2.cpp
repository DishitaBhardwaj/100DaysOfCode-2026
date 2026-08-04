//Need to find the first invalid delivery record

#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

int main()
{
    vector<vector<string>> deliveries = {
        {"V1", "L100", "A"},
        {"V2", "L200", "B"},
        {"V1", "L100", "A"},
        {"V1", "L100", "C"}
    };

    unordered_map<string, string> records;

    for (int i = 0; i < deliveries.size(); i++)
    {
        string key = deliveries[i][0] + "#" + deliveries[i][1];
        string cert = deliveries[i][2];

        // first time seeing this vendor and lot
        if (records.find(key) == records.end())
        {
            records[key] = cert;
        }
        // certification changed for the same vendor and lot
        else if (records[key] != cert)
        {
            cout << i;
            return 0;
        }
    }

    cout << -1;

    return 0;
}