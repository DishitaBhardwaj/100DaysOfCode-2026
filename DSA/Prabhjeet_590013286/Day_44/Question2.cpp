//Need to check if the favourite number gets removed or not

#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> nums = {4, 3, 3, 2, 3};
    int favoriteIndex = 2;
    int k = 2;

    int favorite = nums[favoriteIndex - 1];

    int greater = 0;
    int equal = 0;

    // count numbers above and equal to our favourite
    for (int x : nums)
    {
        if (x > favorite)
            greater++;
        else if (x == favorite)
            equal++;
    }

    if (greater >= k)
        cout << "NO";
    else if (greater + equal <= k)
        cout << "YES";
    else
        cout << "MAYBE";

    return 0;
}
