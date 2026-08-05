#include <stdlib.h>

typedef struct
{
    int vendor;
    int lot;
    int cert;
} Record;

int firstInvalidRecord(Record records[], int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (records[i].vendor == records[j].vendor &&
                records[i].lot == records[j].lot)
            {
                if (records[i].cert != records[j].cert)
                    return i;
            }
        }
    }

    return -1;
}