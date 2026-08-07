#include <stdio.h>
#include <string.h>

void findAnagrams(char log[], char pattern[])
{
    int n = strlen(log);
    int m = strlen(pattern);

    int freqP[26] = {0};
    int freqW[26] = {0};

    for(int i = 0; i < m; i++)
    {
        freqP[pattern[i] - 'a']++;
        freqW[log[i] - 'a']++;
    }

    for(int i = 0; i <= n - m; i++)
    {
        int same = 1;

        for(int j = 0; j < 26; j++)
        {
            if(freqP[j] != freqW[j])
            {
                same = 0;
                break;
            }
        }

        if(same)
            printf("%d ", i);

        if(i < n - m)
        {
            freqW[log[i] - 'a']--;
            freqW[log[i + m] - 'a']++;
        }
    }
}

int main()
{
    char log[] = "cbaebabacd";
    char pattern[] = "abc";

    findAnagrams(log, pattern);

    return 0;
}