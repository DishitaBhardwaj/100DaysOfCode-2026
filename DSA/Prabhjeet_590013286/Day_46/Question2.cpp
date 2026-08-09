//Need to rearrange the array to get the maximum prefix difference score

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<int> nums = {7, 6, 5};

    if (nums.size() <= 1)
    {
        cout << 0;
        return 0;
    }

    int smallest = *min_element(nums.begin(), nums.end());
    int largest = *max_element(nums.begin(), nums.end());

    // first prefix gives 0, every prefix after that can have full range
    long long score = 1LL * (nums.size() - 1) * (largest - smallest);

    cout << score;

    return 0;
}
