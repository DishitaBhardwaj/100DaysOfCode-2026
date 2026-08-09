#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

void reconstructArray(int n, int b[])
{
    int size = n * (n - 1) / 2;

    qsort(b, size, sizeof(int), compare);

    int index = 0;

    for (int i = 0; i < n - 1; i++)
    {
        printf("%d ", b[index]);
        index += (n - i - 1);
    }

    printf("1000000000\n");
}