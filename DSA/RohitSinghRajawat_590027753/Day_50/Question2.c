#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int lastStoneWeight(int stones[], int n)
{
    while(n > 1)
    {
        qsort(stones, n, sizeof(int), compare);

        int y = stones[n - 1];
        int x = stones[n - 2];

        n -= 2;

        if(y != x)
        {
            stones[n] = y - x;
            n++;
        }
    }

    if(n == 1)
        return stones[0];

    return 0;
}

int main()
{
    int stones[] = {2, 7, 4, 1, 8, 1};
    int n = sizeof(stones) / sizeof(stones[0]);

    printf("%d\n", lastStoneWeight(stones, n));

    return 0;
}