#include <stdlib.h>
#include <string.h>

char* officePrinterWars(char* jobs)
{
    int n=strlen(jobs);

    int *sales=(int *)malloc(n * sizeof(int));
    int *marketing=(int *)malloc(n * sizeof(int));
    int sf=0,sr=0;
    int mf=0,mr=0;

    for (int i=0;i<n;i++) {
        if (jobs[i]=='S')
            sales[sr++]=i;
        else
            marketing[mr++]=i;
    }
    while (sf<sr&&mf<mr) 
    {
        int s=sales[sf++];
        int m=marketing[mf++];
        if (s<m)
            sales[sr++]=s+n;
        else
            marketing[mr++]=m+n;
    }
    free(sales);
    free(marketing);
    return (sf < sr) ? "Sales" : "Marketing";
}