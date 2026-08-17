#include <vector>
using namespace std;

string favouriteNumber(vector<int>& nums, int favoriteIndex, int k) {
    int fav = nums[favoriteIndex - 1];

    int greater = 0, equal = 0;

    for (int x : nums) {
        if (x > fav)
            greater++;
        else if (x == fav)
            equal++;
    }

    if (greater >= k)
        return "NO";
    if (greater + equal <= k)
        return "YES";

    return "MAYBE";
}