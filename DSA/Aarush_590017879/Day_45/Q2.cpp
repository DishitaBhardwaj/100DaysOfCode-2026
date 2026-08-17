#include <iostream>
#include <vector>
using namespace std;

long long merge(vector<int>& arr, int low, int mid, int high) {
    vector<int> temp;
    int left = low;
    int right = mid + 1;
    long long inv = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp.push_back(arr[left++]);
        } else {
            temp.push_back(arr[right++]);
            inv += (mid - left + 1);
        }
    }

    while (left <= mid)
        temp.push_back(arr[left++]);

    while (right <= high)
        temp.push_back(arr[right++]);

    for (int i = low; i <= high; i++)
        arr[i] = temp[i - low];

    return inv;
}

long long mergeSort(vector<int>& arr, int low, int high) {
    if (low >= high)
        return 0;

    int mid = (low + high) / 2;

    long long inv = 0;

    inv += mergeSort(arr, low, mid);
    inv += mergeSort(arr, mid + 1, high);
    inv += merge(arr, low, mid, high);

    return inv;
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << mergeSort(arr, 0, n - 1);

    return 0;
}