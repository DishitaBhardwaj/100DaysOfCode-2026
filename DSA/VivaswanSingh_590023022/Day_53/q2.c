#include <stdlib.h>

int* findAnagrams(char* log, char* pattern, int* returnSize)
{
    int freqP[26] = {0};
    int freqW[26] = {0};

    int m = 0, n = 0;

    while (pattern[m] != '\0')
    {
        freqP[pattern[m] - 'a']++;
        m++;
    }

    while (log[n] != '\0')
        n++;

    int *result = (int *)malloc(n * sizeof(int));
    *returnSize = 0;

    for (int i = 0; i < n; i++)
    {
        freqW[log[i] - 'a']++;

        if (i >= m)
            freqW[log[i - m] - 'a']--;

        if (i >= m - 1)
        {
            int ok = 1;

            for (int j = 0; j < 26; j++)
            {
                if (freqP[j] != freqW[j])
                {
                    ok = 0;
                    break;
                }
            }

            if (ok)
                result[(*returnSize)++] = i - m + 1;
        }
    }

    return result;
}