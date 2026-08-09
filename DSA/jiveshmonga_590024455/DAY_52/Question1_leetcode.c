#include <stdbool.h>
#include <string.h>
bool areOccurrencesEqual(char *s) 
{
    int freq[26]={0};
    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }
    int first=0;
    for (int i = 0; i < 26; i++) 
    {
        if (freq[i] != 0) {
            if (first == 0)
                first = freq[i];
            else if (freq[i] != first)
                return false;
        }
    }
    return true;
}