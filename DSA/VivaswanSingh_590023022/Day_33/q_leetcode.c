char* removeOuterParentheses(char* s)
{
    int n = strlen(s);
    char *result = (char *)malloc((n + 1) * sizeof(char));

    int depth = 0;
    int index = 0;

    for (int i = 0; i < n; i++)
    {
        if (s[i] == '(')
        {
            if (depth > 0)
                result[index++] = '(';

            depth++;
        }
        else
        {
            depth--;

            if (depth > 0)
                result[index++] = ')';
        }
    }

    result[index] = '\0';

    return result;
}