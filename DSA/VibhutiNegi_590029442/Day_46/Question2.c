#include <stdio.h>
void sort(int arr[], int n);
int main()
{
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    sort(arr, n);
    int newArr[n];
    if (n == 1)
    {
        newArr[0] = arr[0];
    }
    else
    {
        newArr[0] = arr[0];
        newArr[1] = arr[n - 1];
        int k = 2;
        for (int i = 1; i < n - 1; i++)
        {
            newArr[k] = arr[i];
            k++;
        }
    }
    int minPrefix = newArr[0];
    int maxPrefix = newArr[0];
    int score = 0;
    for (int i = 0; i < n; i++)
    {
        if (newArr[i] < minPrefix)
        {
            minPrefix = newArr[i];
        }
        if (newArr[i] > maxPrefix)
        {
            maxPrefix = newArr[i];
        }
        score = score + (maxPrefix - minPrefix);
    }
    printf("%d", score);
    return 0;
}
void sort(int arr[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}