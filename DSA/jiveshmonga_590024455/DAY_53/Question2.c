#include <stdio.h>
#include <string.h>
void findAnagrams(char log[], char pattern[]) 
{
    int n=strlen(log);
    int m=strlen(pattern);
    if (m>n)
        return;
    int pFreq[26]={0};
    int wFreq[26]={0};
    for (int i=0;i<m;i++) 
    {
        pFreq[pattern[i]-'a']++;
        wFreq[log[i]-'a']++;
    }
    for (int i=0;i<=n-m;i++) 
    {
        int match = 1;
        for (int j = 0; j < 26; j++) 
        {
            if (pFreq[j] != wFreq[j]) 
            {
                match = 0;
                break;
            }
        }
        if (match)
            printf("%d ", i);

        if (i < n - m) 
        {
            wFreq[log[i] - 'a']--;
            wFreq[log[i + m] - 'a']++;
        }
    }
}
int main() 
{
    char log[]="cbaebabacd";
    char pattern[]="abc";
    printf("Starting indices: ");
    findAnagrams(log, pattern);
    return 0;
}