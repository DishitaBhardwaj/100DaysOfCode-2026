#include <stdio.h>

void maxWindow(int arr[], int n, int k)
{
    for(int i = 0; i <= n - k; i++)
    {
        int max = arr[i];

        for(int j = i; j < i + k; j++)
        {
            if(arr[j] > max)
                max = arr[j];
        }

        printf("%d ", max);
    }
}

int main()
{
    int arr[] = {1,3,-1,-3,5,3,6,7};
    int n = 8;
    int k = 3;

    maxWindow(arr,n,k);

    return 0;
}