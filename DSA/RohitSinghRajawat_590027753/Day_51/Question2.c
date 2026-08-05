#include <stdio.h>

int firstInvalidRecord(int records[][3], int n)
{
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < i; j++)
        {
            if(records[i][0] == records[j][0] &&
               records[i][1] == records[j][1] &&
               records[i][2] != records[j][2])
            {
                return i;
            }
        }
    }

    return -1;
}

int main()
{
    int records[][3] = {
        {1, 101, 500},
        {2, 201, 600},
        {1, 101, 500},
        {3, 301, 700},
        {1, 101, 800}
    };

    int n = sizeof(records) / sizeof(records[0]);

    int ans = firstInvalidRecord(records, n);

    printf("%d\n", ans);

    return 0;
}