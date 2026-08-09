#include <stdio.h>
long long merge(int arr[], int temp[], int left, int mid, int right)
{
    int i = left;
    int j = mid + 1;
    int k = left;
    long long count = 0;
    while (i <= mid && j <= right)
    {
        if (arr[i] <= arr[j])
        {
            temp[k] = arr[i];
            i++;
        }
        else
        {
            temp[k] = arr[j];
            count = count + (mid - i + 1);
            j++;
        }
        k++;
    }
    while (i <= mid)
    {
        temp[k] = arr[i];
        i++;
        k++;
    }
    while (j <= right)
    {
        temp[k] = arr[j];
        j++;
        k++;
    }
    for (i = left; i <= right; i++)
        arr[i] = temp[i];
    return count;
}
long long mergeSort(int arr[], int temp[], int left, int right)
{
    long long count = 0;
    if (left < right)
    {
        int mid = (left + right) / 2;
        count += mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);
        count += merge(arr, temp, left, mid, right);
    }
    return count;
}
int main()
{
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    int temp[n];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    long long ans = mergeSort(arr, temp, 0, n - 1);
    printf("Number of inversions = %lld\n", ans);
    return 0;
}