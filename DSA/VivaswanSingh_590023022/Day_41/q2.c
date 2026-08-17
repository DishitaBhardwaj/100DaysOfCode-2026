#include <stdlib.h>


char* predictPartyVictory(char* jobs)
{
    int n = 0;
    while (jobs[n] != '\0')
        n++;

    int sales[10000], marketing[10000];
    int sf = 0, sr = 0;
    int mf = 0, mr = 0;

    for (int i = 0; i < n; i++)
    {
        if (jobs[i] == 'S')
            sales[sr++] = i;
        else
            marketing[mr++] = i;
    }

    while (sf < sr && mf < mr)
    {
        int s = sales[sf++];
        int m = marketing[mf++];

        if (s < m)
            sales[sr++] = s + n;
        else
            marketing[mr++] = m + n;
    }

    if (sf < sr)
        return "Sales";

    return "Marketing";
}