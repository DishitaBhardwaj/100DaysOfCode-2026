#include <stdio.h>
#include <string.h>

char* winner(char jobs[])
{
    int n = strlen(jobs);

    int sales[1000], marketing[1000];
    int sf = 0, sr = -1;
    int mf = 0, mr = -1;

    for(int i = 0; i < n; i++)
    {
        if(jobs[i] == 'S')
            sales[++sr] = i;
        else
            marketing[++mr] = i;
    }

    while(sf <= sr && mf <= mr)
    {
        int s = sales[sf++];
        int m = marketing[mf++];

        if(s < m)
            sales[++sr] = s + n;
        else
            marketing[++mr] = m + n;
    }

    if(sf <= sr)
        return "Sales";

    return "Marketing";
}

int main()
{
    char jobs[] = "SMM";

    printf("%s\n", winner(jobs));

    return 0;
}