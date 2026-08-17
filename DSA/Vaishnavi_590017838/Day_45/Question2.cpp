#include <iostream>
#include <vector>
using namespace std;

long long merge(vector<int>& arr, int left, int mid, int right) {
    vector<int> temp;
    int i = left;
    int j = mid + 1;
    long long inversions = 0;
    while(i <= mid && j <= right) {
        if(arr[i] <= arr[j]) {
            temp.push_back(arr[i]);
            i++;
        }
        else {
            temp.push_back(arr[j]);
            inversions += (mid - i + 1);
            j++;
        }
    }
    while(i <= mid) {
        temp.push_back(arr[i]);
        i++;
    }
    while(j <= right) {
        temp.push_back(arr[j]);
        j++;
    }
    for(int k = left; k <= right; k++) {
        arr[k] = temp[k - left];
    }
    return inversions;
}

long long mergeSort(vector<int>& arr, int left, int right) {
    if(left >= right)
        return 0;

    int mid = left + (right - left) / 2;

    long long inversions = 0;
    inversions += mergeSort(arr, left, mid);
    inversions += mergeSort(arr, mid + 1, right);
    inversions += merge(arr, left, mid, right);
    return inversions;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the array elements: ";
    for(int i = 0; i < n; i++)
        cin >> arr[i];
    cout << "Total Inversions: "
         << mergeSort(arr, 0, n - 1);
    return 0;
}
