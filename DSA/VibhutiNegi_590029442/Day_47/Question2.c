#include <stdio.h>
#include <limits.h>
int max(int a, int b)
{
    return (a > b) ? a : b;
}
int min(int a, int b)
{
    return (a < b) ? a : b;
}
int kthElement(int a[], int n, int b[], int m, int k)
{
    if(n > m)
        return kthElement(b, m, a, n, k);
    int left = max(0, k - m);
    int right = min(k, n);
    while(left <= right)
    {
        int partA = (left + right) / 2;
        int partB = k - partA;
        int leftA = (partA == 0) ? INT_MIN : a[partA - 1];
        int rightA = (partA == n) ? INT_MAX : a[partA];
        int leftB = (partB == 0) ? INT_MIN : b[partB - 1];
        int rightB = (partB == m) ? INT_MAX : b[partB];
        if(leftA <= rightB && leftB <= rightA)
        {
            return max(leftA, leftB);
        }
        else if(leftA > rightB)
        {
            right = partA - 1;
        }
        else
        {
            left = partA + 1;
        }
    }

    return -1;
}
int main()
{
    int n, m, k;
    scanf("%d", &n);
    int a[n];
    for(int i = 0; i < n; i++)
        scanf("%d", &a[i]);
    scanf("%d", &m);
    int b[m];
    for(int i = 0; i < m; i++)
        scanf("%d", &b[i]);
    scanf("%d", &k);
    printf("%d", kthElement(a, n, b, m, k));
    return 0;
}