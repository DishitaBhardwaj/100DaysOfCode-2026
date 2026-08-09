//Need to count how many pairs are in the wrong order

#include <iostream>
#include <vector>
using namespace std;

long long mergeAndCount(vector<long long>& arr, int left, int mid, int right)
{
    vector<long long> temp;

    int i = left;
    int j = mid + 1;
    long long count = 0;

    while (i <= mid && j <= right)
    {
        if (arr[i] <= arr[j])
        {
            temp.push_back(arr[i++]);
        }
        else
        {
            temp.push_back(arr[j++]);

            // everything left from i to mid forms an inversion
            count += mid - i + 1;
        }
    }

    while (i <= mid)
        temp.push_back(arr[i++]);

    while (j <= right)
        temp.push_back(arr[j++]);

    for (int k = 0; k < temp.size(); k++)
    {
        arr[left + k] = temp[k];
    }

    return count;
}

long long countInversions(vector<long long>& arr, int left, int right)
{
    if (left >= right)
        return 0;

    int mid = left + (right - left) / 2;

    long long count = 0;

    count += countInversions(arr, left, mid);
    count += countInversions(arr, mid + 1, right);
    count += mergeAndCount(arr, left, mid, right);

    return count;
}

int main()
{
    vector<long long> arr = {2, 4, 1, 3, 5};

    cout << countInversions(arr, 0, arr.size() - 1);

    return 0;
}
