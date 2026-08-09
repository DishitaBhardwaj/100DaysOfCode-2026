bool areOccurrencesEqual(char* s)
{
    int freq[26] = {0};

    for(int i = 0; s[i] != '\0'; i++)
    {
        freq[s[i] - 'a']++;
    }

    int same = 0;

    for(int i = 0; i < 26; i++)
    {
        if(freq[i] > 0)
        {
            if(same == 0)
            {
                same = freq[i];
            }
            else if(freq[i] != same)
            {
                return false;
            }
        }
    }

    return true;
}