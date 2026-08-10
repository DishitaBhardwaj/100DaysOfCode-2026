int countGoodSubstrings(char* s)
{
    int ans = 0;

    for(int i = 0; s[i] != '\0'; i++)
    {
        if(s[i + 1] == '\0' || s[i + 2] == '\0')
            break;

        if(s[i] != s[i + 1] &&
           s[i] != s[i + 2] &&
           s[i + 1] != s[i + 2])
        {
            ans++;
        }
    }

    return ans;
}