int countGoodSubstrings(char* s)
{
    int n = 0;

    while (s[n] != '\0')
        n++;

    int count = 0;

    for (int i = 0; i <= n - 3; i++)
    {
        if (s[i] != s[i + 1] &&
            s[i] != s[i + 2] &&
            s[i + 1] != s[i + 2])
        {
            count++;
        }
    }

    return count;
}